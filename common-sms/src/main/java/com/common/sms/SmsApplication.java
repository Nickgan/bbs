package com.common.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/**
 * 系统公告
 *
 * @author gan
 * @date 2018/10/24 下午6:43
 */

@EntityScan("com.exchange.bbs.entity.sms")
@SpringBootApplication
public class SmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }
}
