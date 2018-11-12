package com.exchange.bbs.post.service.impl;

import com.exchange.bbs.post.repository.PostRepository;
import com.exchange.bbs.post.service.PostService;
import com.exchange.bbs.post.vo.AddPostReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 帖子
 *
 * @author gan
 * @date 2018/10/24 下午8:48
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void add(AddPostReq req) {

    }
}
