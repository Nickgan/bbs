package com.exchange.bbs.forum.repository;

import com.exchange.bbs.core.repository.BaseRepository;
import com.exchange.bbs.forum.entity.ForumCategory;

/**
 * 版块分类
 *
 * @author gan
 * @date 2018/10/24 下午9:08
 */
public interface ForumCategoryRepository extends BaseRepository<ForumCategory, String> {

    ForumCategory findByName(String name);

    ForumCategory getById(String id);

}
