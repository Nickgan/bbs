package com.exchange.bbs.log.service;

import com.exchange.bbs.entity.bbslog.BbsLog;
import com.exchange.bbs.log.vo.BbsLogListReq; /**
 * bbs日志
 *
 * @author gan
 * @date 2018/10/24 下午9:37
 */
public interface BbsLogService {

    void add(BbsLog bbsLog);

    void list(BbsLogListReq req);
}
