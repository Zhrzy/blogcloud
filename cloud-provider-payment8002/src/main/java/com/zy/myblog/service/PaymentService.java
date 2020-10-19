package com.zy.myblog.service;

import com.zy.myblog.entities.PayMent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface PaymentService {
    public int create(PayMent payment);

    public PayMent getPaymentById(@Param("id") Long id);
}
