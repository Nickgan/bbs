package com.exchange.bbs.log.service.impl;

import com.exchange.bbs.entity.bbslog.BbsLog;
import com.exchange.bbs.log.repository.BbsLogRepository;
import com.exchange.bbs.log.service.BbsLogService;
import com.exchange.bbs.log.vo.BbsLogListReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * bbs日志
 *
 * @author gan
 * @date 2018/10/24 下午9:38
 */

@Service
public class BbsLogServiceImpl implements BbsLogService {

    @Autowired
    private BbsLogRepository bbsLogRepository;

    @Override
    public void add(BbsLog bbsLog) {
        bbsLogRepository.save(bbsLog);
    }

    @Override
    public void list(BbsLogListReq req) {
        Sort sort = new Sort(Sort.Direction.ASC, "id", "createTime");
        Pageable pageable = new PageRequest(req.getCurrentPage(), req.getPageSize(), sort);
        List<Object> params = new ArrayList<>();
        String hql = "FROM BbsLog o where";
        bbsLogRepository.getResultPageByQuery(hql, pageable, params);
    }
}
