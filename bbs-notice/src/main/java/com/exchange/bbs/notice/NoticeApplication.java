package com.exchange.bbs.notice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author gan
 * @date 2018/10/24 下午3:47
 */

//@EnableJpaRepositories("com.exchange.bbs.notice.repository")          // JPA扫描该包路径下的Repositorie
//扫描实体类(实体类不在本模块中,必须添加该扫描注解,同时也是为了精确的扫描自己模块的实体类）
@EntityScan("com.exchange.bbs.entity.notice")
@SpringBootApplication
public class NoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeApplication.class, args);
    }
}
