package com.common.sms.service;

import com.common.sms.vo.SendSmsReq; /**
 * 公共短信服务
 *
 * @author gan
 * @date 2018/11/20 12:41 PM
 */
public interface SmsService {

    /**
     * 发送短信
     * @param req
     */
    void sendSms(SendSmsReq req);

}
