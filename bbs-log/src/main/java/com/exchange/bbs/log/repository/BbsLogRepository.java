package com.exchange.bbs.log.repository;

import com.exchange.bbs.common.repository.BaseRepository;
import com.exchange.bbs.entity.bbslog.BbsLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * bbs日志
 *
 * @author gan
 * @date 2018/10/24 下午9:34
 */
public interface BbsLogRepository extends BaseRepository<BbsLog, String> {

}
