package com.exchange.bbs.user.repository;

import com.exchange.bbs.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * bbs用户
 *
 * @author gan
 * @date 2018/10/24 下午8:33
 */
public interface UserRepository extends JpaRepository<User, String> {


}
