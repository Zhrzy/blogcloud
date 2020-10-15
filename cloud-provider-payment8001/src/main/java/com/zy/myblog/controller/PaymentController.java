package com.zy.myblog.controller;

import com.zy.myblog.entities.PayMent;
import com.zy.myblog.service.PaymentService;
import com.zy.myblog.untils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        PayMent payMent = paymentService.getPaymentById(id);
        return new CommonResult(200, "成功",payMent);
    }

}
