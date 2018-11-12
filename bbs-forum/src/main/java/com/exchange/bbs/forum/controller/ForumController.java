package com.exchange.bbs.forum.controller;

import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.dto.BaseResult;
import com.exchange.bbs.forum.service.ForumCategoryService;
import com.exchange.bbs.forum.service.ForumService;
import com.exchange.bbs.forum.vo.AddForumReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版块
 *
 * @author gan
 * @date 2018/10/24 下午7:13
 */

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    /**
     * 新增版块
     *
     * @return
     */
    @PostMapping
    public BaseResult add(@ParamValidate AddForumReq req) {
        forumService.add(req);
        return BaseResult.success();
    }

}
