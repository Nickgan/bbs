package com.exchange.bbs.post.repository;

import com.exchange.bbs.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 帖子
 *
 * @author gan
 * @date 2018/10/24 下午8:48
 */

public interface PostRepository extends JpaRepository<Post, String> {

}
