package com.exchange.bbs.log.service;

import com.exchange.bbs.log.entity.BbsLog;
import com.exchange.bbs.log.vo.BbsLogListReq;
import org.springframework.data.domain.Page;

/**
 * bbs日志
 *
 * @author gan
 * @date 2018/10/24 下午9:37
 */
public interface BbsLogService {

    void add(BbsLog bbsLog);

    Page<BbsLog> list(BbsLogListReq req);
}
