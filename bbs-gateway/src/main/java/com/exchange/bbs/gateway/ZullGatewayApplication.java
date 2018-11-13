package com.exchange.bbs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * bbs 网关服务
 *
 * @author gan
 * @date 2018/10/26 下午3:55
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableEurekaClient
public class ZullGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZullGatewayApplication.class, args);
    }
}
