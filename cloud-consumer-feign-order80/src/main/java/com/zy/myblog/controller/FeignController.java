package com.zy.myblog.controller;

import com.zy.myblog.entities.PayMent;
import com.zy.myblog.service.FeignPaymentService;
import com.zy.myblog.untils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy 1716457206@qq.com
 */
@RestController
public class FeignController {

    @Autowired
    private FeignPaymentService feignPaymentService;
    @GetMapping("/feign/consumer/getpaymentbyid/{id}")
    public CommonResult<PayMent> getPaymentById(@PathVariable("id") Long id){
    return  feignPaymentService.getPaymentById(id);
    }
}
