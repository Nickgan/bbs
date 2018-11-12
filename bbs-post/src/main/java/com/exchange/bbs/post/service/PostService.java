package com.exchange.bbs.post.service;

import com.exchange.bbs.post.vo.AddPostReq;

/**
 * 帖子
 *
 * @author gan
 * @date 2018/10/24 下午8:47
 */
public interface PostService {

    /**
     * 发帖
     *
     * @param req
     */
    void add(AddPostReq req);

}
