package com.exchange.bbs.post.service.impl;

import com.exchange.bbs.post.entity.Post;
import com.exchange.bbs.post.enums.PostStatus;
import com.exchange.bbs.post.repository.PostRepository;
import com.exchange.bbs.post.service.PostService;
import com.exchange.bbs.post.vo.AddPostReq;
import org.springframework.beans.BeanUtils;
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
        Post post = new Post();
        BeanUtils.copyProperties(req, post);
        post.setStatus(PostStatus.PROCESSING);

        //TODO 待远程调用用户和板块服务完善用户名和板块名
        postRepository.save(post);
    }
}
