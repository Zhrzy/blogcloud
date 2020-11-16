package com.zy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.zy.myblog.MyRoundBalance;
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
