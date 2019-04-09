package com.exchange.bbs.user.service.impl;

import com.exchange.bbs.user.entity.User;
import com.exchange.bbs.user.repository.UserRepository;
import com.exchange.bbs.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * bbs用户
 *
 * @author gan
 * @date 2018/10/24 下午8:34
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(String id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}
