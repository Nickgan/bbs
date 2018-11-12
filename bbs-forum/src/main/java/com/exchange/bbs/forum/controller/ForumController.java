package com.exchange.bbs.forum.controller;

import com.exchange.bbs.common.annotation.ParamValidate;
import com.exchange.bbs.common.dto.BaseResult;
import com.exchange.bbs.forum.service.ForumCategoryService;
import com.exchange.bbs.forum.service.ForumService;
import com.exchange.bbs.forum.vo.AddForumReq;
import com.exchange.bbs.forum.vo.ForumListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 版块
 *
 * @author gan
 * @date 2018/10/24 下午7:13
 */

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    /**
     * 新增版块
     *
     * @return
     */
    @PostMapping
    public BaseResult add(@ParamValidate AddForumReq req) {
        forumService.add(req);
        return BaseResult.success();
    }


    /**
     * 删除版块
     *
     * @param id
     * @return
     */
    @DeleteMapping
    @ParamValidate
    public BaseResult delete(@NotBlank(message = "版块Id不能为空") String id) {
        forumService.delete(id);
        return BaseResult.success();
    }

    /**
     * 版块列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<ForumListResp> list() {
        return forumService.list();
    }

    /**
     * 新增主题数(发一篇帖子,对应版块主题数量加一)
     *
     * @param forumId
     * @return
     */
    @GetMapping("/addPostCount")
    @ParamValidate
    public BaseResult addPostCount(@NotBlank(message = "版块Id不能为空")String forumId) {
        forumService.addPostCount(forumId);
        return BaseResult.success();
    }


    /**
     * 新增版块帖子回复数(回复帖子,对应版块帖子回复数量加一)
     *
     * @param forumId
     * @return
     */
    @GetMapping("/addReplyCount")
    @ParamValidate
    public BaseResult addReplyCount(@NotBlank(message = "版块Id不能为空") String forumId) {
        forumService.addReplyCount(forumId);
        return BaseResult.success();
    }
}
