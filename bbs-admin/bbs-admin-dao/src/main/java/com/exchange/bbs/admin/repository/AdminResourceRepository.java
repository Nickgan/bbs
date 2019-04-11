package com.exchange.bbs.admin.repository;


import com.exchange.bbs.admin.entity.AdminResource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 后台系统资源
 *
 * @author gan
 * @date 2018/10/24 下午7:26
 */
public interface AdminResourceRepository extends JpaRepository<AdminResource, String> {

}
