package com.exchange.bbs.web.service.impl;

import com.exchange.bbs.web.service.ForumService;
import com.exchange.bbs.web.utils.ConstantConfig;
import com.exchange.bbs.web.utils.HttpClientUtils;
import org.springframework.stereotype.Service;

/**
 * 版块
 *
 * @author gan
 * @date 2018/10/26 下午1:45
 */

@Service
public class ForumServiceImpl implements ForumService{

    @Override
    public String categoryList() throws Exception {
        return HttpClientUtils.get(ConstantConfig.API_FORUM_CATEGORY_LIST);
    }
}
