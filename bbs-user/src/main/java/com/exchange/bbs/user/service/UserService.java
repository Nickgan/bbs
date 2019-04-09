package com.exchange.bbs.user.service;


import com.exchange.bbs.user.entity.User;

import java.util.List;

/**
 * bbs用户
 *
 * @author gan
 * @date 2018/10/24 下午8:34
 */
public interface UserService {

    User get(String id);

    List<User> list();
}
