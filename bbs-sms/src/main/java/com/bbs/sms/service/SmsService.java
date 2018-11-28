package com.bbs.sms.service;

import com.bbs.sms.vo.SendSmsReq;
import com.bbs.sms.vo.CheckCodeReq;

/**
 * 公共短信服务
 *
 * @author gan
 * @date 2018/11/20 12:41 PM
 */
public interface SmsService {

    /**
     * 发送短信
     *
     * @param req
     */
    void sendSms(SendSmsReq req);

    /**
     * 校验短信
     *
     * @param req
     */
    void checkCode(CheckCodeReq req);

}
