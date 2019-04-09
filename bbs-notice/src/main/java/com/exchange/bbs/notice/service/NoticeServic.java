package com.exchange.bbs.notice.service;

import com.exchange.bbs.notice.entity.Notice;
import com.exchange.bbs.notice.vo.AddNoticeReq;

/**
 * 系统公告
 *
 * @author gan
 * @date 2018/10/24 下午4:46
 */
public interface NoticeServic {

    /**
     * 获取系统最新公告
     *
     * @return
     */
    Notice getFirst();

    /**
     * 新增公告
     *
     * @param vo
     */
    void add(AddNoticeReq vo);
}
