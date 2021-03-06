package com.exchange.bbs.forum.repository;

import com.exchange.bbs.core.repository.BaseRepository;
import com.exchange.bbs.forum.entity.Forum;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 版块
 *
 * @author gan
 * @date 2018/10/24 下午7:17
 */
public interface ForumRepository extends BaseRepository<Forum, String> {

    Forum findByName(String name);

    @Query("select o from Forum o where o.category.id = ?1 ")
    List<Forum> findByCategoryId(String categoryId);

    @Query("select o from Forum o where o.id = ?1 ")
    Forum findByForumId(String id);

}
