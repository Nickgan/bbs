package com.exchange.bbs.common.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 扩展公共jap接口实现
 *
 * @author gan
 * @date 2018/11/1 上午11:22
 */

@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    @Autowired
    private EntityManager entityManager;
    private Class<T> domainClass;
    private JpaEntityInformation<T, ?> entityInformation;

    private static final String SQL_COUNT = "SELECT COUNT(1) ";
    private static final String SQL_LIST = "SELECT o  ";
    private static final String SQL_ORDER = " ORDER BY ";


    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
        this.domainClass = entityInformation.getJavaType();
        System.out.println("===========domainClass=====>" + domainClass);
    }

    private void prepareQueryParam(Query query, List<Object> params) {
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i + 1, params.get(i));
            }
        }
    }

    public Page<T> getResultPageByQuery(String hql, Pageable pageable, List<Object> params) {
        String countQryS = SQL_COUNT + hql;
        Query countQry = entityManager.createQuery(countQryS);
        prepareQueryParam(countQry, params);
        long total = (Long) (countQry.getSingleResult());

        List<T> result;
        if (total > pageable.getOffset()) {
            StringBuilder qryS = new StringBuilder();
            qryS.append(SQL_LIST);
            qryS.append(hql);
            if (pageable.getSort() != null) {// 处理排序问题
                qryS.append(SQL_ORDER);
                for (Sort.Order order : pageable.getSort()) {
                    qryS.append(order.getProperty()).append(" ");
                    qryS.append(order.getDirection().toString());
                }
            }
            Query query = entityManager.createQuery(qryS.toString(), domainClass);
            prepareQueryParam(query, params);
            Long offset = pageable.getOffset();
            query.setFirstResult(offset.intValue());
            query.setMaxResults(pageable.getPageSize());
            result = query.getResultList();
        } else {
            result = Collections.emptyList();
        }
        return new PageImpl<T>(result, pageable, total);
    }

    public List<T> findByHql(String hql, List<Object> params) {
        Query query = entityManager.createQuery(hql, domainClass);
        prepareQueryParam(query, params);
        List<T> resultList = query.getResultList();
        return resultList;
    }

}
