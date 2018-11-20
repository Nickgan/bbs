package com.common.sms.service.impl;

import com.common.sms.repository.SmsRepository;
import com.common.sms.service.SmsService;
import com.common.sms.vo.SendSmsReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 公共短信服务
 *
 * @author gan
 * @date 2018/11/20 12:41 PM
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsRepository smsRepository;


    @Override
    public void sendSms(SendSmsReq req) {

    }
}
