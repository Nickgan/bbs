package com.exchange.bbs.forum.service;

import com.exchange.bbs.forum.vo.AddForumReq;
import com.exchange.bbs.forum.vo.ForumListResp;

import java.util.List;

/**
 * 版块
 *
 * @author gan
 * @date 2018/10/24 下午7:19
 */
public interface ForumService {

    /**
     * 新增版块
     *
     * @param req
     */
    void add(AddForumReq req);

    void delete(String id);

    List<ForumListResp> list();

}
