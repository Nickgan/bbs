package com.common.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author gan
 * @date 2018/11/20 9:46 PM
 */
@Configuration
@ConfigurationProperties(prefix = "aliyunsms")
@Data
public class AliyunSmsConfig {

    private String accesskey;
    private String secretKey;

}
