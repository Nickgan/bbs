package com.exchange.bbs.log.controller;

import com.exchange.bbs.common.controller.BaseController;
import com.exchange.bbs.common.dto.BaseResult;
import com.exchange.bbs.entity.bbslog.BbsLog;
import com.exchange.bbs.log.service.BbsLogService;
import com.exchange.bbs.log.vo.BbsLogListReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * bbs日志
 *
 * @author gan
 * @date 2018/10/24 下午9:32
 */

@RestController
@RequestMapping("/log")
public class BbsLogController extends BaseController {

    @Autowired
    private BbsLogService bbsLogService;

    @PostMapping
    public BaseResult add(BbsLog bbsLog) {
        bbsLogService.add(bbsLog);
        return BaseResult.success();
    }

    @GetMapping("/list")
    public Object list(BbsLogListReq req) {
        Page<BbsLog> pageList = bbsLogService.list(req);
        return BaseResult.success(pageList);
    }
}
