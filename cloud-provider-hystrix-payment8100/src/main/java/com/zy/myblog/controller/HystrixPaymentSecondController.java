package com.zy.myblog.controller;

import com.zy.myblog.service.PaymentServiceSecond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy 1716457206@qq.com
 */
@RestController
public class HystrixPaymentSecondController {
    @Autowired
    private PaymentServiceSecond paymentServiceSecond;

    @GetMapping("/hy/get/ok1")
    public String ok1(){
        return paymentServiceSecond.ok1();
    }
    @GetMapping("/hy/get/ok2")
    public String ok2(){
        return paymentServiceSecond.ok2();
    }
    @GetMapping("/hy/get/ok3")
    public String ok3() {
        return paymentServiceSecond.ok3();
    }
    @GetMapping("/hy/get/ok4")
    public String ok4() {
        return paymentServiceSecond.ok4();
    }

}
