package com.exchange.bbs.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象
 *
 * @param <T>
 * @author gan
 * @since 2016年5月20日上午1:06:11
 */
public class Pager<T> {
    // 为什么使用int,为了避免判断currentPage是否位null
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult [pageSize=" + pageSize + ", currentPage="
                + currentPage + ", totalCount=" + totalCount + ", totalPage="
                + totalPage + ", rows.size=" + rows.size() + "]";
    }

}
