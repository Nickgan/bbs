package com.exchange.bbs.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * 后台管理
 *
 * @author gan
 * @date 2018/10/24 下午6:43
 */

@SpringBootApplication
@EntityScan("com.exchange.bbs.entity.admin")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
