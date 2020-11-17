package com.zy.myblog.controller;

import com.zy.myblog.service.PaymentServiceFeignSecond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy 1716457206@qq.com
 */
@RestController
public class OrderHystrixControllerSecond {
    @Autowired
    private PaymentServiceFeignSecond paymentServiceFeignSecond;
    @GetMapping("/get/order/ok1")
    public String ok1(){
        return paymentServiceFeignSecond.ok1();
    }

    @GetMapping("/get/order/ok2")
    public String ok2(){
        return paymentServiceFeignSecond.ok2();
    }
}
