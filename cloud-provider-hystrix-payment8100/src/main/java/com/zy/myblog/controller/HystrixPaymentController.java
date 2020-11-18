package com.zy.myblog.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zy.myblog.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy 1716457206@qq.com
 */
@RestController
public class HystrixPaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/hystrix/getok/{id}")
    public String getOk(@PathVariable("id") Long id){
        return paymentService.getOK(id);
    }

    @GetMapping("/hystrix/gettimeout/{id}")
    public String getTimeOut(@PathVariable("id") Long id){
        return paymentService.getTimeOut(id);
    }

    @GetMapping("/hystrix/globle")
    public String getTimeOutGloble(){
        return paymentService.getTimeOutGloble();
    }

    @GetMapping("/hystrix/cut/{id}")
    public String ServiceCut(@PathVariable("id") int id) {
        return paymentService.ServerCut(id);
    }



    /*服务熔断******************************/

    @GetMapping("/hy/ok1")
    public String getok1(){
        return paymentService.getOk1();
    }

    @GetMapping("/hy/ok2")
    public String getok2(){
        return paymentService.getOk2();
    }

    /*服务熔断******************************/

}
