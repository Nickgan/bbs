package com.exchange.bbs.common.query;


import com.exchange.bbs.common.utils.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 抽象查询对象类
 *
 * @author gan
 * @since 2016年5月20日上午1:06:24
 */

public abstract class BaseQuery {

    private int currentPage;
    private int pageSize;
    private StringBuilder countHql;
    private StringBuilder hql;
    private List<Object> paramsList;
    private boolean flag;

    private String sort;    //排序列
    private String order;   //排序方式

    public BaseQuery(Class<?> entityClass) {
        countHql = new StringBuilder("SELECT COUNT(o) FROM " + entityClass.getName() + " o ");
        hql = new StringBuilder("FROM " + entityClass.getName() + " o ");
        paramsList = new ArrayList();
    }

    public abstract void addWhere();

    public void addWhere(String condition, Object... params) {
        if (paramsList.size() == 0) {
            countHql.append(" WHERE " + condition);
            hql.append(" WHERE " + condition);
        } else {
            countHql.append(" AND " + condition);
            hql.append(" AND " + condition);
        }
        paramsList.addAll(Arrays.asList(params));
    }

    public void buildWhere() {
        if (!flag) {
            addWhere();
            flag = true;
            //排序
            if (StringUtil.stringsIsNotBlack(sort, order)) {
                hql.append(" order by o." + sort + "  " + order);
            }
        }
    }

    public String getHql() {
        buildWhere();
        return hql.toString();
    }

    public String getCountHql() {
        buildWhere();
        return countHql.toString();
    }

    public List<Object> getParamsList() {
        buildWhere();
        return paramsList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setOrder(String order) {
        this.order = order;
    }

}
