package com.exchange.bbs.notice.controller;

import com.exchange.bbs.entity.notice.Notice;
import com.exchange.bbs.notice.service.NoticeServic;
import com.exchange.common.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统公告
 *
 * @author gan
 * @date 2018/10/24 下午3:44
 */

@RestController
public class NoticeController {

    @Autowired
    private NoticeServic noticeServic;

    @GetMapping("/notice")
    public BaseResult getFirst() {
        Notice notice = noticeServic.getFirst();
        return BaseResult.success(notice);
    }

}
