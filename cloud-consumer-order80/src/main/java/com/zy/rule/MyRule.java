package com.zy.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.zy.myblog.conf.MyRoundBalance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zy 1716457206@qq.com
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myRules(){
        new RoundRobinRule();
        return  new MyRoundBalance();
    }
}
