package com.exchange.bbs.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 版块和版块分类
 *
 * @author gan
 * @date 2018/10/24 下午8:55
 */
@SpringBootApplication(scanBasePackages = "com.exchange.bbs.*")
@EntityScan("com.exchange.bbs.entity.forum")
@EnableDiscoveryClient
public class ForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }
}
