package com.exchange.bbs.reply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * 回复
 *
 * @author gan
 * @date 2018/10/24 下午6:43
 */

@SpringBootApplication
@EntityScan("com.exchange.bbs.entity.reply")
public class ReplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReplyApplication.class, args);
    }
}
