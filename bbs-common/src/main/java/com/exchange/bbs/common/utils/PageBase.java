package com.exchange.bbs.common.utils;

import lombok.Data;

/**
 * 分页基类
 * Created by ganbo on 2019/4/15.
 */
@Data
public class PageBase {
    private int pageSize;
    private int currentPage;
}
