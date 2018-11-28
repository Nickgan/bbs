package com.bbs.sms.vo;

import lombok.Data;

/**
 * 验证码校验
 *
 * @author gan
 * @date 2018/11/20 9:52 PM
 */

@Data
public class CheckCodeReq {

    private String mobile;
    private String code;
    private String source;

}
