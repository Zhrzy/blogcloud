package com.zy.myblog.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zy.myblog.service.PaymentServiceFeignSecond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/get/order/ok3")

    @HystrixCommand(fallbackMethod = "ok3fallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="14500")
    })
    public String ok3(){
        return paymentServiceFeignSecond.ok3();
    }

    public String ok3fallback()
    {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    @GetMapping("/get/order/ok4")
    public String ok4(){
        return paymentServiceFeignSecond.ok4();
    }


    @GetMapping("/get/ok5/{id}")
    public String ok5(@PathVariable("id") Integer id) {
        return paymentServiceFeignSecond.ok5(id);
    }

}
