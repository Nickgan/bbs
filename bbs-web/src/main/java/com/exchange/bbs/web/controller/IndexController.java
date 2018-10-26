package com.exchange.bbs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * bbs首页
 *
 * @author gan
 * @date 2018/10/25 下午11:31
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        System.out.println("=============index===");
        return "index";
    }

}
