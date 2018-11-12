package com.exchange.bbs.post.controller;

import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.dto.BaseResult;
import com.exchange.bbs.post.service.PostService;
import com.exchange.bbs.post.vo.AddPostReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 帖子
 *
 * @author gan
 * @date 2018/10/24 下午8:43
 */

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PutMapping("/add")
    public BaseResult add(@ParamValidate AddPostReq req){
        postService.add(req);
        return BaseResult.success();
    }

}
