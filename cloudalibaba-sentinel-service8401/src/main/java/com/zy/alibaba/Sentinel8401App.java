package com.zy.alibaba;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel8401App {
    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401App.class, args);
    }
}
