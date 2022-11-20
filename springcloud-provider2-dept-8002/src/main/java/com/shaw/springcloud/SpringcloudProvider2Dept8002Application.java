package com.shaw.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com/shaw/springcloud/mapper")
@SpringBootApplication
@EnableEurekaClient
public class SpringcloudProvider2Dept8002Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudProvider2Dept8002Application.class, args);
	}

}
