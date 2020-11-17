package com.zy.myblog.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zy 1716457206@qq.com
 */
@Component
/*@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentServiceFallBack.class)*/
public interface PaymentServiceFeign {

    @GetMapping("/hystrix/getok/{id}")
    public String getok(@PathVariable("id") long id);

    @GetMapping("/hystrix/gettimeout/{id}")
    public String getTimeOut(@PathVariable("id")Long id);

    @GetMapping("/hystrix/gettimeout/")
    public String getTimeOutGloble();

    @GetMapping("/hystrix/cut/{id}")
    public String ServiceCut(@PathVariable("id") int id);
}
