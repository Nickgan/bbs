package com.exchange.bbs.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * bbs Eureka 服务注册中心
 *
 * @author gan
 * @date 2018/10/25 下午1:15
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSecondApplication.class, args);
    }

}
