package com.exchange.bbs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * bbs首页
 *
 * @author gan
 * @date 2018/10/25 下午11:31
 */

@Controller
public class IndexController extends BaseController {

    @RequestMapping("/{page}")
    public String page(@PathVariable(value = "page") String page) {
        System.out.println("page=================="+page);
        return page;
    }

}
