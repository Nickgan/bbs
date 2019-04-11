package com.bbs.sms.repository;

import com.bbs.sms.entity.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 公共短信服务
 *
 * @author gan
 * @date 2018/11/20 12:40 PM
 */
public interface SmsRepository extends JpaRepository<Sms, String> {

    /**
     * 根据手机号和系统来源查询当天同一个手机号发送的次数
     *
     * @param mobile 手机号
     * @param source 来源(系统名)
     * @param mow    当天日期的yyyy-MM-dd格式
     * @return
     */
    @Query(value = "SELECT * FROM common_sms WHERE mobile = ?1 AND source = ?2 AND DATE(CREATETIME) = ?3 ", nativeQuery = true)
    List<Sms> findByMobileAndDateSourceByToday(String mobile, String source, String mow);

    @Query(value = "SELECT o FROM Sms o WHERE o.mobile = ?1 AND o.source = ?2 ")
    List<Sms> findByMobileAndSource(String mobile, String source);

}
