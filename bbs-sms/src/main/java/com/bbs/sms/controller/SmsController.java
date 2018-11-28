package com.bbs.sms.controller;

import com.bbs.sms.service.SmsService;
import com.bbs.sms.vo.SendSmsReq;
import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.controller.BaseController;
import com.exchange.bbs.common.dto.BaseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 公共的短信服务
 *
 * @author gan
 * @date 2018/11/20 11:45 AM
 */
@RequestMapping("/sms")
@RestController
public class SmsController extends BaseController {

    @Autowired
    private SmsService smsService;

    /**
     * 发送短信
     */
    @ApiOperation(value = "发送短信", notes = "发送短信接口")
    @PostMapping("/send")
    public BaseResult sendSms(@RequestBody @ParamValidate SendSmsReq req) {
        smsService.sendSms(req);
        return BaseResult.success();
    }

}
