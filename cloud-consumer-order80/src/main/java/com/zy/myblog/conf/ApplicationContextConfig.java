package com.zy.myblog.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zy 1716457206@qq.com
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //注释掉RestTemplate的LoadBalanced，屏蔽其默认的负载均衡算法
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
