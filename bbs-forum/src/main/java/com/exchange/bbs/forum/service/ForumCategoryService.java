package com.exchange.bbs.forum.service;

import com.exchange.bbs.forum.entity.ForumCategory;
import com.exchange.bbs.forum.vo.AddForumCategoryReq;
import com.exchange.bbs.forum.vo.UpdateForumCategoryReq;

import java.util.List;

/**
 * 版块分类
 *
 * @author gan
 * @date 2018/10/24 下午9:10
 */
public interface ForumCategoryService {

    void add(AddForumCategoryReq req);

    List<ForumCategory> findAll();

    ForumCategory get(String id);

    void deleteById(String id);

    void update(UpdateForumCategoryReq req);

}
