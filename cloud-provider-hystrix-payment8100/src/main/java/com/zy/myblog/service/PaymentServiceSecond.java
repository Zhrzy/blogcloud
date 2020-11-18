package com.zy.myblog.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zy 1716457206@qq.com
 */
@Service
@DefaultProperties(defaultFallback = "globalFallback")
public class PaymentServiceSecond {

    public String ok1() {
        return "ok1.............";
    }


    @HystrixCommand(fallbackMethod = "ok2Fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String ok2() {
        int b = 1 / 0;
        return "ok2-timeout--5000ms.....";
    }

    /* 一对一示：fallback方法，定义在生产者的服务降级方法 */
    public String ok2Fallback() {
        return "我是8100---》ok2()方法的服务降级";
    }

    @HystrixCommand(fallbackMethod = "ok3Fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String ok3() {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok3--timeout3000ms";
    }

    /* 一对一示：fallback方法，定义在生产者的服务降级方法 */
    public String ok3Fallback() {
        return "我是8100---》ok3()方法的服务降级";
    }


    @HystrixCommand //没指定任何fallback方法，使用全局的
    public String ok4(){
        int a=1/0;
        return "ok4.........";
    }



    /*本class全局的fallback*/
    public String globalFallback(){
        return "我是8100全局的服降级";
    }


}
