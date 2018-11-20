package com.common.sms.controller;

import com.common.sms.vo.SendSmsReq;
import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.controller.BaseController;
import com.exchange.bbs.common.dto.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共的短信服务
 *
 * @author gan
 * @date 2018/11/20 11:45 AM
 */
@RequestMapping("/sms")
@RestController
public class SmsController extends BaseController {


    /**
     * 发送短信
     */
    @GetMapping("/send")
    public BaseResult sendSms(@ParamValidate SendSmsReq req) {

        return BaseResult.success();
    }

}
