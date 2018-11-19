package com.exchange.bbs.log.service.impl;

import com.exchange.bbs.entity.bbslog.BbsLog;
import com.exchange.bbs.log.repository.BbsLogRepository;
import com.exchange.bbs.log.service.BbsLogService;
import com.exchange.bbs.log.vo.BbsLogListReq;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
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
    public Page<BbsLog> list(BbsLogListReq req) {
        Sort sort = new Sort(Sort.Direction.ASC, "createTime");
        Pageable pageable = new PageRequest(req.getCurrentPage(), req.getPageSize(), sort);
        List<Object> params = new ArrayList<>();
        String hql = "FROM BbsLog o ";
        boolean firstCondition = true;
        if (StringUtils.isNotBlank(req.getUsername())) {
            hql.concat("WHERE o.username like ?1 ");
            params.add("%" + req.getUsername() + "%");
            firstCondition = false;
        }
        if (req.getBbsLogType() != null) {
            if (firstCondition) {
                hql.concat("WHERE o.bbsLogType = ?2 ");
                params.add(req.getBbsLogType());
                firstCondition = false;
            } else {
                hql.concat("AND o.bbsLogType = ?2");
            }
        }
        Page<BbsLog> page = bbsLogRepository.getResultPageByQuery(hql, pageable, params);
        return page;
    }
}
