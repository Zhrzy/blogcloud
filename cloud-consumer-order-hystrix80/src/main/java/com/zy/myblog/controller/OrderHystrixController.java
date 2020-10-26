package com.zy.myblog.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zy.myblog.service.PaymentServiceFeign;
import io.micrometer.core.instrument.Meter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy 1716457206@qq.com
 */
@RestController
@DefaultProperties(defaultFallback = "globleDefaultFallBack")
public class OrderHystrixController {

    @Autowired
    private PaymentServiceFeign paymentServiceFeign;

    @GetMapping("/hystrix/order/get/{id}")
    public String getok(@PathVariable("id") Long id){
        System.out.println("1234");
        return paymentServiceFeign.getok(id);
    }

    @GetMapping("/hystrix/order/gettimeout/{id}")
    @HystrixCommand(fallbackMethod = "orderFallBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="9000")
    })
    public String getTimeOut(@PathVariable("id")Long id){
       // int age=1/0;
        return paymentServiceFeign.getTimeOut(id);
    }

    @GetMapping("/hystrix/getgloble/")
    @HystrixCommand
    public String getGloble(){
        int age=1/0;
        return paymentServiceFeign.getTimeOutGloble();
    }

    public String orderFallBack(Long id){
        return "80自己的服务降级功能 。失败调用";
    }

    /*定义全局的服务降级*/
    public String globleDefaultFallBack(){
        return "全局的服务降级.";
    }

    @GetMapping("/h/cut/{id}")
    public  String getCutService(@PathVariable("id") int id){

        return paymentServiceFeign.ServiceCut(id);
    }

}
