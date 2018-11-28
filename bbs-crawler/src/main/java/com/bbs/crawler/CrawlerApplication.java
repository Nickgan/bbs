package com.bbs.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * bbs爬虫模块
 *
 * @author gan
 * @date 2018/11/28 10:26 AM
 */
@SpringBootApplication(scanBasePackages = "com.exchange.bbs.*")
@EntityScan("com.exchange.bbs.entity.bbslog")
public class CrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrawlerApplication.class, args);
    }
}
