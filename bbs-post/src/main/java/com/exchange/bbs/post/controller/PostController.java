package com.exchange.bbs.post.controller;

import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.controller.BaseController;
import com.exchange.bbs.common.dto.BaseResult;
import com.exchange.bbs.common.query.BaseQuery;
import com.exchange.bbs.post.service.PostService;
import com.exchange.bbs.post.vo.AddPostReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 帖子
 *
 * @author gan
 * @date 2018/10/24 下午8:43
 */

@RestController
@RequestMapping("/post")
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    @PutMapping
    public BaseResult add(@ParamValidate AddPostReq req) {
        postService.add(req);
        return BaseResult.success();
    }

    @GetMapping("/list")
    public BaseResult list(BaseQuery query) {

        return BaseResult.success();
    }

}
