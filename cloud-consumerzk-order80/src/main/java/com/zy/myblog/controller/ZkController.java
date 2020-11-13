package com.zy.myblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZkController {

    private  String url="http://cloud-provider-paymentzk";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/get/zk")
    public String getByZk(){
        return restTemplate.getForObject(url+"/payment/zk",String.class);
    }


}
