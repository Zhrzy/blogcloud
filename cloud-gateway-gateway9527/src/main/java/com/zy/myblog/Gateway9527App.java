package com.zy.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.sql.SQLOutput;

/**
 * @author zy 1716457206@qq.com
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527App {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9527App.class, args);
    }
}
