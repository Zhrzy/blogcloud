package com.zy.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @auther zzyy
 * @create 2020-02-24 16:26
 */
@RestController
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        System.out.println(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC()
    {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"...testC");
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD()
    {
        int a=1/0;
        System.out.println(Thread.currentThread().getName()+"\t"+"...testD");
        return "------testD";
    }


}
