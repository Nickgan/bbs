package com.exchange.bbs.forum.repository;

import com.exchange.bbs.common.repository.BaseRepository;
import com.exchange.bbs.entity.forum.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 版块
 *
 * @author gan
 * @date 2018/10/24 下午7:17
 */
public interface ForumRepository extends BaseRepository<Forum, String> {

    Forum findByName(String name);

}
