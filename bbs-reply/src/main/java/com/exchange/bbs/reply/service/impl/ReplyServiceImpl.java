package com.exchange.bbs.reply.service.impl;

import com.exchange.bbs.reply.repository.ReplyRepository;
import com.exchange.bbs.reply.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 回复
 *
 * @author gan
 * @date 2018/10/24 下午6:49
 */

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyRepository replyRepository;

}
