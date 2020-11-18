package com.zy.myblog.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zy 1716457206@qq.com
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentServiceFeignSecondFallback.class)
public interface PaymentServiceFeignSecond {

    @GetMapping("/hy/get/ok1")
    public String ok1() ;

    @GetMapping("/hy/get/ok2")
    public String ok2();

    @GetMapping("/hy/get/ok3")
    public String ok3();

    @GetMapping("/hy/get/ok4")
    public String ok4();

}
