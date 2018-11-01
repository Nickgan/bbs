package com.exchange.bbs.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 扩展Jpa 公共方法的Repository
 *
 * @author gan
 * @date 2018/10/25 下午4:03
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    /**
     * 高级查询by hql
     *
     * @param hql      查询hql
     * @param pageable 分页排序对象
     * @param params   查询参数
     * @return 分页对象
     * @date 2017年5月6日 下午4:04:45
     */
    Page<T> getResultPageByQuery(String hql, Pageable pageable, List<Object> params);

    List<T> findByHql(String hql, List<Object> params);
}
