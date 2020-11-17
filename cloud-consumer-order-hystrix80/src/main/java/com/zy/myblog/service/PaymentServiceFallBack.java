package com.zy.myblog.service;

import org.springframework.stereotype.Component;

/**
 * @author zy 1716457206@qq.com
 */
/*
*实现Feign调用的接口
 *  */
@Component
public class PaymentServiceFallBack implements PaymentServiceFeign {
    @Override
    public String getok(long id) {
        return "作用于feign客户端接口的fallback --- getok";
    }

    @Override
    public String getTimeOut(Long id) {
        return "作用于feign客户端接口的fallback --- getTimeOut";
    }

    @Override
    public String getTimeOutGloble() {
        return "作用于feign客户端接口的fallback --- getTimeOutGloble";
    }

    @Override
    public String ServiceCut(int id) {
        return "作用于feign客户端接口的fallback --- ServiceCut";
    }
}
