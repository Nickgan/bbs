package com.exchange.bbs.notice.service.impl;

import com.exchange.bbs.entity.notice.Notice;
import com.exchange.bbs.notice.repository.NoticeRepository;
import com.exchange.bbs.notice.service.NoticeServic;
import com.exchange.bbs.notice.vo.AddNoticeReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统公告
 *
 * @author gan
 * @date 2018/10/24 下午4:46
 */

@Service
public class NoticeServiceImpl implements NoticeServic {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public Notice getFirst() {
        return noticeRepository.getFirst();
    }

    @Override
    public void add(AddNoticeReq vo) {
        Notice notice = new Notice();
        BeanUtils.copyProperties(vo, notice);
        noticeRepository.save(notice);
    }
}
