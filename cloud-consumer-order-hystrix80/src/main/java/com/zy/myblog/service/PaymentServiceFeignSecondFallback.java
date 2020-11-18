package com.zy.myblog.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFeignSecondFallback implements PaymentServiceFeignSecond {
    @Override
    public String ok1() {
        return "80ok1,服务降级，实现feign接口调用";
    }

    @Override
    public String ok2() {
        return "80ok2服务降级，实现feign接口调用";
    }

    @Override
    public String ok3() {
        return "80ok3服务降级，实现feign接口调用";
    }

    @Override
    public String ok4() {
        return "80ok4服务降级，实现feign接口调用";
    }
}
