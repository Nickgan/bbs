package com.exchange.bbs.user.repository;

import com.exchange.bbs.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * bbs用户
 *
 * @author gan
 * @date 2018/10/24 下午8:33
 */
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT o FROM User o WHERE o.id = ?1 ")
    User getById(String id);

}
