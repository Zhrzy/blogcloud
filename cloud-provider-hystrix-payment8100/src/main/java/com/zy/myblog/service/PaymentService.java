package com.zy.myblog.service;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.hystrix.HystrixProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author zy 1716457206@qq.com
 */
@Service
public class PaymentService {

    public String getOK(Long id){
        try {
            Thread.currentThread().sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hystrix return ID:"+id+" is OK";
    }

    @HystrixCommand(fallbackMethod = "testFallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String getTimeOut(Long id){
        int a = 1/0;
        /*try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //try { TimeUnit.MILLISECONDS.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "服务端8100 ：Hystrix return ID:"+id+" is TIMEOUT: 4000ms";
    }
    public  String testFallBack(Long id){
        return "服务端8100 ：Hystrix fallback ------服务超时或则错误";
    }

    public String getTimeOutGloble(){ return  "服务端接口调用"; }




    /*服务熔断*/

    @HystrixCommand(defaultFallback = "fallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String ServerCut(@PathVariable("id") int ids){
        int id = ids;
        if(id<0){
            throw new RuntimeException("失败");
        }
        return "调用成功：" + id;

    }

    public String fallBack(@PathVariable("id") int id){
        return "调用失败：" + id;
    }


}
