package com.zwj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class RecruitApplication {
    public static void main(String[] args) {
        SpringApplication.run( RecruitApplication.class);
    }




//    @Bean //IdWorker放入ioc容器 （1. @Bean +返回值  2.三层注解 ）
//    public IdWorker idWorker(){
//        return new IdWorker(1,1);
//    }
}

