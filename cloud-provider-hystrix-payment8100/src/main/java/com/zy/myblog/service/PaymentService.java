package com.zy.myblog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

    public String getTimeOutGloble(){

        return  "服务端接口调用";
    }


    public  String testFallBack(Long id){
        return "服务端8100 ：Hystrix fallback ------服务超时或则错误";
    }



}
