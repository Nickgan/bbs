package com.exchange.bbs.notice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gan
 * @date 2018/10/24 下午3:44
 */

@RestController
public class NoticeController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
