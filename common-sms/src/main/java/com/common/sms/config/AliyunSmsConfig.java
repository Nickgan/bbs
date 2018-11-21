package com.common.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云配置信息
 *
 * @author gan
 * @date 2018/11/20 9:46 PM
 */
@Configuration
@ConfigurationProperties(prefix = "aliyun.sms")
@Data
public class AliyunSmsConfig {

    private String accesskey;
    private String secretKey;
    private int phoneMax;           //同一个手机号码一天最多发送次数
    private int sendMessageTime;    //同一个号码两次短信最小间隔时间一分钟
    private int codeValidTime;      //短信有效时间5分钟

}
