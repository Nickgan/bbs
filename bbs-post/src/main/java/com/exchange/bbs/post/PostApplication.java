package com.exchange.bbs.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * 帖子
 *
 * @author gan
 * @date 2018/10/24 下午8:43
 */

@SpringBootApplication
@EntityScan("com.exchange.bbs.entity.post")
public class PostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostApplication.class, args);
    }
}
