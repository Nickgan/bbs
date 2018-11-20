package com.common.sms.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.common.sms.config.AliyunSmsConfig;
import com.common.sms.repository.SmsRepository;
import com.common.sms.service.SmsService;
import com.common.sms.utils.AliYunSmsHelper;
import com.common.sms.vo.CheckCodeReq;
import com.common.sms.vo.SendSmsReq;
import com.exchange.bbs.common.exception.BusinessException;
import com.exchange.bbs.common.exception.enums.OpenApiException;
import com.exchange.bbs.common.utils.DateUtils;
import com.exchange.bbs.common.utils.JSonUtils;
import com.exchange.bbs.common.utils.StringUtil;
import com.exchange.bbs.entity.sms.Sms;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 公共短信服务
 *
 * @author gan
 * @date 2018/11/20 12:41 PM
 */
@Service
public class SmsServiceImpl implements SmsService {
    private Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Autowired
    private SmsRepository smsRepository;
    @Autowired
    private AliyunSmsConfig aliyunSmsConfig;
    @Autowired
    private AliYunSmsHelper aliYunSmsHelper;


    @Override
    public void sendSms(SendSmsReq req) {
        Date now = new Date();

        // 1:检查是否频繁发送和发送次数超过当天的最大次数限制
        List<Sms> smses = smsRepository.findByMobileAndDateSourceByToday(req.getMobile(), req.getSource(), DateUtils.formateDateyyyy_MM_dd(now));
        if (!CollectionUtils.isEmpty(smses)) {
            if (smses.size() > aliyunSmsConfig.getPhoneMax()) {
                throw new BusinessException(OpenApiException.SMS_CODE_OUT_LIMIT);
            }
            if (now.getTime() - smses.get(0).getCreateTime().getTime() <= aliyunSmsConfig.getSendMessageTime()) {
                throw new BusinessException(OpenApiException.SMS_CODE_TIME_SORT);
            }
        }

        //发送短信
        try {
            aliYunSmsHelper.sendRegisterSms(req);
        } catch (ClientException e) {
            throw new BusinessException(OpenApiException.SMS_SEND_ERROR);
        }

        Sms sms = Sms.builder().mobile(req.getMobile()).source(req.getSource())
                .ip(req.getIp()).signName(req.getSignName()).params(JSonUtils.objectToJson(req.getParams())).build();
        smsRepository.save(sms);

    }

    @Override
    public void checkCode(CheckCodeReq req) {
        List<Sms> smses = smsRepository.findByMobileAndSource(req.getMobile(), req.getSource());
        if (CollectionUtils.isEmpty(smses)) {
            throw new BusinessException(OpenApiException.SMS_CODE_ERROR);
        }

        Sms sms = smses.get(0);
        if (new Date().getTime() - sms.getCreateTime().getTime() > aliyunSmsConfig.getCodeValidTime()) {
            throw new BusinessException(OpenApiException.SMS_CODE_TIMEOUT);
        }

        //检验验证码的正确性(这里要求需要check的验证码sms参数params里面验证码字段key必须为code)
        HashMap params = JSonUtils.jsonToPojo(sms.getParams(), HashMap.class);
        if (!req.getMobile().equals(params.get("code"))) {
            throw new BusinessException(OpenApiException.SMS_CODE_ERROR);
        }
    }
}
