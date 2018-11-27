package com.exchange.bbs.gateway.cofig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关bean过滤器
 *
 * @author gan
 * @date 2018/11/27 2:47 PM
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/bruce")
                        .uri("http://www.jianshu.com/u/128b6effde53")
                ).build();
    }
}
