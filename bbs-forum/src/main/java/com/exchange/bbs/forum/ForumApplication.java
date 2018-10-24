package com.exchange.bbs.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * 版块和版块分类
 *
 * @author gan
 * @date 2018/10/24 下午8:55
 */
@SpringBootApplication
@EntityScan("com.exchange.bbs.entity.forum")
public class ForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }
}
