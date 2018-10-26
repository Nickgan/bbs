package com.exchange.bbs.forum.service.impl;

import com.exchange.bbs.entity.forum.ForumCategory;
import com.exchange.bbs.forum.repository.ForumCategoryRepository;
import com.exchange.bbs.forum.service.ForumCategoryService;
import com.exchange.bbs.forum.vo.AddForumCategoryReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 版块分类
 *
 * @author gan
 * @date 2018/10/24 下午9:11
 */

@Service
public class ForumCatetoryServiceImpl implements ForumCategoryService {

    @Autowired
    private ForumCategoryRepository forumCategoryRepository;

    @Override
    public void add(AddForumCategoryReq req) {
        ForumCategory category = new ForumCategory();
        BeanUtils.copyProperties(req, category);
        forumCategoryRepository.save(category);
    }

    @Override
    public List<ForumCategory> findAll() {
        return forumCategoryRepository.findAll();
    }
}
