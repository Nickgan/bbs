package com.exchange.bbs.web.controller;

import com.exchange.bbs.web.service.ForumService;
import com.exchange.bbs.web.utils.JSONUtil;
import com.exchange.bbs.web.vo.ForumListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/forum/categoryList")
    @ResponseBody
    public String categoryList() throws Exception {
        return forumService.categoryList();
    }

    @RequestMapping("/forum/list")
    @ResponseBody
    public List<ForumListResp> forumList() throws Exception {
        return JSONUtil.jsonArrayToObjectList(forumService.forumList(), ForumListResp.class);
    }

}
