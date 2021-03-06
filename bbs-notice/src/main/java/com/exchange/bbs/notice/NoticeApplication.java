package com.exchange.bbs.notice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/**
 * 系统公告
 *
 * @author gan
 * @date 2018/10/24 下午6:43
 */

@EntityScan("com.exchange.bbs.entity.notice")
@SpringBootApplication
public class NoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeApplication.class, args);
    }
}
