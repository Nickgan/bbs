package com.common.sms.repository;

import com.exchange.bbs.entity.sms.Sms;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 公共短信服务
 *
 * @author gan
 * @date 2018/11/20 12:40 PM
 */
public interface SmsRepository extends JpaRepository<Sms, String> {


}
