package com.shaw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringcloudConsumeDeptRfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumeDeptRfeignApplication.class, args);
    }

}
