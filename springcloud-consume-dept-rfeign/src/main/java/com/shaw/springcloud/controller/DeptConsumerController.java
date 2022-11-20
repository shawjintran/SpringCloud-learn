package com.shaw.springcloud.controller;

import com.shaw.springcloud.pojo.Dept;
import com.shaw.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

	//直接通过RPC 联系服务提供者
	// @Autowired
	// RestTemplate restTemplate;
	//提供多种便捷访问远程http服务的方法,简单的RestFul服务
	//Ribbon或者是Rest时,都是通过RestTemplate实现
	//而当使用Feign时,直接接口实现

	@Autowired
	DeptClientService deptClientService;



	@GetMapping("/list")
	public List<Dept> list(){
		System.out.println("yes");
		return deptClientService.listall();
	}
}
