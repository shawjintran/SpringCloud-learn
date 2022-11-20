package com.shaw.springcloud.controller;

import com.shaw.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
// @RequestMapping("/dept")
public class DeptConsumerController {
	//	消费者不能有service层
	//	实体以及对象,通过RestTemplate获取
	//	而这种方式就叫做 RPC 远程过程调用

	//当通过Ribbon实现负载均衡时,不要使用固定的服务提供者地址
	//而是直接将这个地址作为变量,通过服务名访问
	// static final String UPL_PERFIX="http://localhost:8001";
	static final String UPL_PERFIX="http://DEPTPROVIDER";


	//直接通过RPC 联系服务提供者
	@Autowired
	RestTemplate restTemplate;
	//提供多种便捷访问远程http服务的方法,简单的RestFul服务

	@GetMapping("/list")
	public List<Dept> list(){
		System.out.println("yes");
		return restTemplate.getForObject(UPL_PERFIX+"/dept/list",List.class);
	}
}
