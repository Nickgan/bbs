package com.exchange.bbs.forum.repository;

import com.exchange.bbs.common.repository.BaseRepository;
import com.exchange.bbs.entity.forum.ForumCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 版块分类
 *
 * @author gan
 * @date 2018/10/24 下午9:08
 */
public interface ForumCategoryRepository extends BaseRepository<ForumCategory, String> {

}
