package com.zy.myblog.service;

import com.zy.myblog.entities.PayMent;
import com.zy.myblog.untils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zy 1716457206@qq.com
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignPaymentService {

    @GetMapping("/payment/get/{id}")
    public CommonResult<PayMent> getPaymentById(@PathVariable("id") Long id);
}
