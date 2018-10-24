package com.exchange.bbs.notice.repository;

import com.exchange.bbs.entity.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 系统公告
 *
 * @author gan
 * @date 2018/10/24 下午4:34
 */
public interface NoticeRepository extends JpaRepository<Notice, String> {

    @Query(value = "select * from bbs_notice n order by n.UPDATETIME DESC limit 1", nativeQuery = true)
    Notice getFirst();
}
