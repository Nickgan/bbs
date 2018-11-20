package com.common.sms.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.common.sms.config.AliyunSmsConfig;
import com.common.sms.vo.SendSmsReq;
import com.exchange.bbs.common.utils.JSonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 阿里云发送短信接口工具类
 *
 * @author ganbo E-mail:bo.gan@56qq.com
 * @since 2018-01-31 16:00
 */
@Component
public class AliYunSmsHelper {

    @Autowired
    private AliyunSmsConfig aliyunSmsConfig;

    private static final String product = "Dysmsapi";  //短信API产品名称（短信产品名固定，无需修改）
    private static final String domain = "dysmsapi.aliyuncs.com"; //短信API产品域名（接口地址固定，无需修改）

    /**
     * 发送注册短信
     *
     * @throws ClientException
     */
    public void sendRegisterSms(SendSmsReq req) throws ClientException {
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliyunSmsConfig.getSecretKey(), aliyunSmsConfig.getAccesskey());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        request.setPhoneNumbers(req.getMobile());
        request.setSignName(req.getSignName());
        request.setTemplateCode(req.getTemplateCode());
        request.setTemplateParam(JSonUtils.objectToJson(req.getParams()));
        request.setOutId("yourOutId");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() == null || !sendSmsResponse.getCode().equals("OK")) {
            throw new ClientException("发送短信失败");
        }
    }
}
