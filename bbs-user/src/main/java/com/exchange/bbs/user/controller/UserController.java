package com.exchange.bbs.user.controller;

import com.exchange.bbs.entity.user.User;
import com.exchange.bbs.user.service.UserService;
import com.exchange.common.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * bbs系统用户
 *
 * @author gan
 * @date 2018/10/24 下午8:32
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User get(@PathVariable(name = "id") String id) {
        User user = userService.get(id);
        return user;
    }
}
