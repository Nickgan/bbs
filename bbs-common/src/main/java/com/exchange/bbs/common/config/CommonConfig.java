package com.exchange.bbs.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 公共的配置类
 *
 * @author gan
 * @date 2018/10/25 下午4:26
 */

@Configuration
public class CommonConfig {


    /**
     * 使用Hibernate做参数校验配置
     *
     * @return
     */
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setProviderClass(org.hibernate.validator.HibernateValidator.class);
        return factoryBean;
    }
}
