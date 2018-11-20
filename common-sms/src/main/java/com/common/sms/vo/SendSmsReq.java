package com.common.sms.vo;

import lombok.Data;

import java.util.Map;

/**
 * 短信发送请求对象
 *
 * @author gan
 * @date 2018/11/20 1:56 PM
 */
@Data
public class SendSmsReq {

    //手机
    private String mobile;

    //参数
    private Map<String, Object> params;

    private String ip;

    //发送来源（一般是系统名称）
    private String source;

    //短信签名
    private String signName = "bruce的网站公共短信服务平台";

    //短信验证码模板
    private String templateCode;

    //是否需要同步发送到钉钉消息群，测试时用
    private boolean syncSendDingDing = false;

    //钉钉消息群Token,默认有一个群
    private String dingDingToken;

    ////是否调试模式，调试模式不会真正发送短信，测试时用
    private boolean debug = false;

    //是否使用缓存中的验证码，在短信发送成功后有可能用户没收到，这时候重发，可以发送之前一样的，如果用户收到了第一次时的短信，就不会出现失效的情况
    private boolean useCacheCode = false;

}
