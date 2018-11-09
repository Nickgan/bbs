package com.exchange.bbs.forum.controller;

import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.controller.BaseController;
import com.exchange.bbs.common.dto.BaseResult;
import com.exchange.bbs.entity.forum.ForumCategory;
import com.exchange.bbs.forum.service.ForumCategoryService;
import com.exchange.bbs.forum.vo.AddForumCategoryReq;
import com.exchange.bbs.forum.vo.UpdateForumCategoryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ForumCategory get(@PathVariable("id") String id) {
        return forumCategoryService.get(id);
    }

    @DeleteMapping("/{id}")
    public BaseResult delete(@PathVariable("id") String id) {
        forumCategoryService.deleteById(id);
        return BaseResult.success();
    }

    @GetMapping("/list")
    public List<ForumCategory> list() {
        return forumCategoryService.findAll();
    }

    @PutMapping
    public BaseResult update(@ParamValidate UpdateForumCategoryReq req) {
        forumCategoryService.update(req);
        return BaseResult.success();
    }


}
