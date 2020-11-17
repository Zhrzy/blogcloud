package com.zy.myblog.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zy 1716457206@qq.com
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentServiceFeignSecond {

    @GetMapping("/hy/get/ok1")
    public String ok1() ;

    @GetMapping("/hy/get/ok2")
    public String ok2();
}
