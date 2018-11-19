package com.exchange.bbs.log.vo;

import com.exchange.bbs.enums.BbsLogType;
import lombok.Data;

/**
 * 分页查询日志列表
 *
 * @author gan
 * @date 2018/11/19 12:31 PM
 */
@Data
public class BbsLogListReq {

    private String username;        //用户名字
    private BbsLogType bbsLogType;  //日志类型
    private int pageSize = 10;      //每页大小
    private int currentPage = 1;    //当前页

}
