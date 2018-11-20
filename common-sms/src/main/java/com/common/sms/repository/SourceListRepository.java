package com.common.sms.repository;

import com.exchange.bbs.entity.sms.SourceList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 短信系统白名单
 *
 * @author gan
 * @date 2018/11/20 2:07 PM
 */
public interface SourceListRepository extends JpaRepository<SourceList, String> {

}
