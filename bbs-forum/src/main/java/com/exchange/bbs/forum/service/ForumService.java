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

    /**
     * 删除版块
     *
     * @param id
     */
    void delete(String id);

    /**
     * 版块列表
     *
     * @return
     */
    List<ForumListResp> list();

    /**
     * 发一篇帖子,对应版块帖子数+1
     *
     * @param forumId 版块id
     */
    void addPostCount(String forumId);

    /**
     * 回复一篇帖子,对应回复数量+1
     *
     * @param forumId
     */
    void addReplyCount(String forumId);
}
