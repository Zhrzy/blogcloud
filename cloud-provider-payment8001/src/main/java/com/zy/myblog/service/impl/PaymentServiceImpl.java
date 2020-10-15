package com.zy.myblog.service.impl;

import com.zy.myblog.dao.PaymentDao;
import com.zy.myblog.entities.PayMent;
import com.zy.myblog.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int create(PayMent payment) {
        return paymentDao.create(payment);
    }

    @Override
    public PayMent getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
