package com.exchange.bbs.forum.controller;

import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.controller.BaseController;
import com.exchange.bbs.common.dto.BaseResult;
import com.exchange.bbs.entity.forum.ForumCategory;
import com.exchange.bbs.forum.service.ForumCategoryService;
import com.exchange.bbs.forum.vo.AddForumCategoryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 版块分类
 *
 * @author gan
 * @date 2018/10/24 下午9:11
 */
@RestController
@RequestMapping("/forumcategory")
public class ForumCategoryController extends BaseController {

    @Autowired
    ForumCategoryService forumCategoryService;
    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 新增版块分类
     *
     * @param req
     * @return
     */
    @PostMapping
    public BaseResult add(@ParamValidate AddForumCategoryReq req) {
        forumCategoryService.add(req);
        return BaseResult.success();
    }

    @GetMapping("/list")
    public List<ForumCategory> list() {
        return forumCategoryService.findAll();
    }

    @GetMapping("/discover")
    public Object discover() {
        List<String> services = discoveryClient.getServices();
        System.out.println("service---------->" + services);
        List<ServiceInstance> instances = discoveryClient.getInstances("BBS-FORUM");

        for (int i = 0; i < instances.size(); i++) {
            System.out.println("==========================");
            ServiceInstance serviceInstance = instances.get(i);
            System.out.println(serviceInstance.getHost());
            System.out.println(serviceInstance.getMetadata());
            System.out.println(serviceInstance.getPort());
            System.out.println(serviceInstance.getServiceId());
            System.out.println(serviceInstance.getUri());
            System.out.println(serviceInstance.getScheme());
        }

        return services;
    }
}
