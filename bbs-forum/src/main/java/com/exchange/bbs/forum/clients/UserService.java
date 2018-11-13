package com.exchange.bbs.forum.clients;

import com.exchange.bbs.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 调用用户服务API
 *
 * @author gan
 * @date 2018/11/13 12:44 PM
 */

@FeignClient(name = "bbs-user")
public interface UserService {

    @GetMapping("/{id}")
    User findById(@PathVariable(name = "id") String id);

}
