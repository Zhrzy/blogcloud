package com.zy.myblog.dao;

import com.zy.myblog.entities.PayMent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int create(PayMent payment);

    public PayMent getPaymentById(@Param("id") Long id);
}
