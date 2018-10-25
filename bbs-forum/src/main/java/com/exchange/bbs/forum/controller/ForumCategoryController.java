package com.exchange.bbs.forum.controller;

import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.controller.BaseController;
import com.exchange.bbs.common.dto.BaseResult;
import com.exchange.bbs.entity.forum.ForumCategory;
import com.exchange.bbs.forum.service.ForumCategoryService;
import com.exchange.bbs.forum.vo.AddForumCategoryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版块分类
 *
 * @author gan
 * @date 2018/10/24 下午9:11
 */
@RestController
@RequestMapping("/forumcategory")
public class ForumCategoryController extends BaseController {

    @Autowired
    ForumCategoryService forumCategoryService;

    /**
     * 新增版块分类
     *
     * @param req
     * @return
     */
    @PostMapping
    public BaseResult add(@ParamValidate AddForumCategoryReq req) {
        forumCategoryService.add(req);
        return BaseResult.success();
    }

}
