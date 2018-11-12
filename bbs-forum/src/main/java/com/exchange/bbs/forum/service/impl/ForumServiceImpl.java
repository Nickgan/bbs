package com.exchange.bbs.forum.service.impl;

import com.exchange.bbs.common.exception.BusinessException;
import com.exchange.bbs.common.exception.enums.OpenApiException;
import com.exchange.bbs.entity.forum.Forum;
import com.exchange.bbs.entity.forum.ForumCategory;
import com.exchange.bbs.forum.repository.ForumCategoryRepository;
import com.exchange.bbs.forum.repository.ForumRepository;
import com.exchange.bbs.forum.service.ForumService;
import com.exchange.bbs.forum.vo.AddForumReq;
import com.exchange.bbs.forum.vo.ForumListDto;
import com.exchange.bbs.forum.vo.ForumListResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
        ForumCategory forumCategory = forumCategoryRepository.getById(req.getCategoryId());
        if (forumCategory == null) {
            throw new BusinessException(OpenApiException.FORUM_CATEGORY_NOT_FOUNT);
        }
        Forum byName = forumRepository.findByName(req.getName());
        if (byName != null) {
            throw new BusinessException(OpenApiException.FORUM_ALREADY_EXIST);
        }
        BeanUtils.copyProperties(req, forum);
        forum.setCategory(forumCategory);
        forumRepository.save(forum);
    }

    @Override
    public void delete(String id) {
        forumRepository.deleteById(id);
    }

    @Override
    public List<ForumListResp> list() {
        List<ForumListResp> list = new ArrayList<>();
        List<ForumCategory> forumCategoryList = forumCategoryRepository.findAll();
        for (ForumCategory category : forumCategoryList) {
            ForumListResp resp = new ForumListResp();
            resp.setCategoryName(category.getName());
            List<Forum> forumList = forumRepository.findByCategoryId(category.getId());
            if (!CollectionUtils.isEmpty(forumList)) {
                List<ForumListDto> dtos = new ArrayList<>();
                for (Forum forum : forumList) {
                    ForumListDto dto = new ForumListDto();
                    BeanUtils.copyProperties(forum, dto);
                    dtos.add(dto);
                }
                resp.setList(dtos);
            }
            list.add(resp);
        }
        return list;
    }
}
