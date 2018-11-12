package com.exchange.bbs.forum.service.impl;

import com.exchange.bbs.common.exception.BusinessException;
import com.exchange.bbs.common.exception.enums.OpenApiException;
import com.exchange.bbs.entity.forum.Forum;
import com.exchange.bbs.entity.forum.ForumCategory;
import com.exchange.bbs.forum.repository.ForumCategoryRepository;
import com.exchange.bbs.forum.service.ForumCategoryService;
import com.exchange.bbs.forum.vo.AddForumCategoryReq;
import com.exchange.bbs.forum.vo.UpdateForumCategoryReq;
import org.hibernate.sql.Update;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        ForumCategory oldByName = forumCategoryRepository.findByName(req.getName());
        if (oldByName != null) {
            throw new BusinessException(OpenApiException.FORUM_CATEGORY_ALREADY_EXIST);
        }

        ForumCategory category = new ForumCategory();
        BeanUtils.copyProperties(req, category);
        forumCategoryRepository.save(category);
    }

    @Override
    public List<ForumCategory> findAll() {
        return forumCategoryRepository.findAll();
    }

    @Override
    public ForumCategory get(String id) {
        return forumCategoryRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        forumCategoryRepository.deleteById(id);
    }

    @Override
    public void update(UpdateForumCategoryReq req) {
        ForumCategory category = forumCategoryRepository.getById(req.getId());
        if (category == null) {
            throw new BusinessException(OpenApiException.FORUM_CATEGORY_NOT_FOUNT);
        }
        BeanUtils.copyProperties(req, category);
        forumCategoryRepository.saveAndFlush(category);
    }


}
