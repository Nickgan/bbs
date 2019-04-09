package com.exchange.bbs.core.config;

import com.exchange.bbs.core.repository.BaseRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

/**
 * 公共的配置类
 *
 * @author gan
 * @date 2018/10/25 下午4:26
 */

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableJpaRepositories(basePackages = "com.**.repository", repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class CommonConfig {


    /**
     * 使用Hibernate做参数校验配置
     */
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setProviderClass(org.hibernate.validator.HibernateValidator.class);
        return factoryBean;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
//
//    /**
//     * 注册自定义Jpa 扩展
//     */
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }

}
