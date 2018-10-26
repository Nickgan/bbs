package com.exchange.bbs.web.controller;

import com.exchange.bbs.web.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 版块
 *
 * @author gan
 * @date 2018/10/26 下午1:47
 */

@Controller
public class ForumController extends BaseController {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/category/list")
    @ResponseBody
    public String list() throws Exception {
        return forumService.categoryList();
    }

}
