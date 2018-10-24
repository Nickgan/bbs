package com.exchange.bbs.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * bbs系统用户
 *
 * @author gan
 * @date 2018/10/24 下午8:35
 */

@SpringBootApplication
@EntityScan("com.exchange.bbs.entity.user")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
