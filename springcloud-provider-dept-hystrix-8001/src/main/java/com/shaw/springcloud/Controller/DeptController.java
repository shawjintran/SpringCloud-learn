package com.shaw.springcloud.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shaw.springcloud.pojo.Dept;
import com.shaw.springcloud.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/dept")
@RestController
@Slf4j
public class DeptController {
	@Autowired
	private DeptService deptService;

	@Autowired
	private DiscoveryClient client;

	@HystrixCommand(fallbackMethod = "Hystrix_get")
	@GetMapping("/get/{id}")
	public Dept get(@PathVariable("id")Long id){
		System.out.println("yes");

		Dept get = deptService.get(id);

		if(get==null)
		{
			throw new RuntimeException("没有数据");
		}
		return get;
	}
	//备选方案
	public Dept Hystrix_get(@PathVariable ("id")Long id){
		System.out.println(id);
		return new Dept().setDname("没有相关数据");
	}



}
