package com.exchange.bbs.reply.repository;

import com.exchange.bbs.entity.reply.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 回复
 *
 * @author gan
 * @date 2018/10/24 下午6:49
 */
public interface ReplyRepository extends JpaRepository<Reply, String> {

}
