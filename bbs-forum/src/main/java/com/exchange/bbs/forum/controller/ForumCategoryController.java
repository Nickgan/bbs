package com.exchange.bbs.forum.controller;

import com.exchange.bbs.forum.service.ForumCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版块分类
 *
 * @author gan
 * @date 2018/10/24 下午9:11
 */
@RestController
public class ForumCategoryController {

    @Autowired
    ForumCategoryService forumCategoryService;

}
