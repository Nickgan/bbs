package com.exchange.bbs.forum.service.impl;

import com.exchange.bbs.common.exception.BusinessException;
import com.exchange.bbs.common.exception.enums.OpenApiException;
import com.exchange.bbs.entity.forum.Forum;
import com.exchange.bbs.entity.forum.ForumCategory;
import com.exchange.bbs.forum.repository.ForumCategoryRepository;
import com.exchange.bbs.forum.repository.ForumRepository;
import com.exchange.bbs.forum.service.ForumService;
import com.exchange.bbs.forum.vo.AddForumReq;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 版块
 *
 * @author gan
 * @date 2018/10/24 下午7:19
 */

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumRepository forumRepository;
    @Autowired
    private ForumCategoryRepository forumCategoryRepository;

    @Override
    public void add(AddForumReq req) {
        Forum forum = new Forum();
        ForumCategory forumCategory = forumCategoryRepository.getOne(req.getCategoryId());
        if (forumCategory == null) {
            throw new BusinessException(OpenApiException.FORUM_CATEGORY_NOT_FOUNT);
        }
        BeanUtils.copyProperties(req, forum);
        forumRepository.save(forum);
    }
}
