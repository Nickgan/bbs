package com.exchange.bbs.admin.repository;


import com.exchange.bbs.admin.entity.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 后台管理用户角色
 *
 * @author gan
 * @date 2018/10/24 下午7:26
 */
public interface AdminRoleRepository extends JpaRepository<AdminRole,String> {

}
