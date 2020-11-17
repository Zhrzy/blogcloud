package com.zy.myblog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author zy 1716457206@qq.com
 */
@Service
public class PaymentServiceSecond {

    public String ok1(){
        return "ok1.............";
    }


    @HystrixCommand(fallbackMethod = "ok2Fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public String ok2(){
        int b=1/0;
        return "ok2-timeout--5000ms.....";
    }


    /* 一对一示：fallback方法，定义在生产者的服务降级方法 */
    public String ok2Fallback() {
        return "我是8100---》ok2()方法的服务降级";
    }

}
