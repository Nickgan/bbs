package com.bbs.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 系统公告
 *
 * @author gan
 * @date 2018/10/24 下午6:43
 */

@EntityScan("com.exchange.bbs.entity.sms")
@SpringBootApplication
@EnableSwagger2
public class SmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }
}
