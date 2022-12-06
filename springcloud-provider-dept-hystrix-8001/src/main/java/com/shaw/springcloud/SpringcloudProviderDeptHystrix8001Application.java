package com.shaw.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @EnableEurekaClient
@EnableHystrix
// @EnableCircuitBreaker
@MapperScan(basePackages = "com/shaw/springcloud/mapper")
//高版本使用这个注解,之前的已经被抛弃
//EnableCircuitBreaker
@EnableDiscoveryClient
public class SpringcloudProviderDeptHystrix8001Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudProviderDeptHystrix8001Application.class, args);
	}

	// @Bean
	// public ServletRegistrationBean a(){
	// 	ServletRegistrationBean bean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
	// 	bean.addUrlMappings("/actuator/hystrix.stream");
	// 	return bean;
	// }
}
