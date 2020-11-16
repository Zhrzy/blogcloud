package com.zy.myblog;

import com.zy.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zy 1716457206@qq.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class FeignConsumerApp80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApp80.class,args);
    }
}
