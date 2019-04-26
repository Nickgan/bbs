package com.exchange.bbs.common.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象
 *
 * @param <T>
 * @author gan
 * @since 2016年5月20日上午1:06:11
 */
@Data
public class Pager<T> {

    private int pageSize;
    private int currentPage;
    private int totalCount;
    private int totalPage;
    private List<T> rows = new ArrayList<T>();

    public Pager() {
    }

    public Pager(int pageSize, int currentPage, int totalCount) {
        this.pageSize = pageSize < 1 ? 10 : pageSize;
        this.totalCount = totalCount;
        this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
        this.currentPage = currentPage < 1 ? 1 : currentPage > this.totalPage ?
                this.totalPage : currentPage;
    }


    @Override
    public String toString() {
        return "PageResult [pageSize=" + pageSize + ", currentPage="
                + currentPage + ", totalCount=" + totalCount + ", totalPage="
                + totalPage + ", rows.size=" + rows.size() + "]";
    }

}
