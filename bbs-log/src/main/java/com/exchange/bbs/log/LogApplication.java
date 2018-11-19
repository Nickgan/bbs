package com.exchange.bbs.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * bbs日志
 *
 * @author gan
 * @date 2018/10/24 下午9:39
 */
@SpringBootApplication(scanBasePackages = "com.exchange.bbs.*")
@EntityScan("com.exchange.bbs.entity.bbslog")
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }
}
