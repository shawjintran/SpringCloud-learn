package com.shaw.springcloud.Controller;

import com.shaw.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shaw.springcloud.service.DeptService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/dept")
@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;

	@Autowired
	private DiscoveryClient client;

	@GetMapping("/list")
	public List<Dept> list(){
		System.out.println("yes");
		return deptService.listall();
	}
	//注册进来的微服务,获取一些消息
	public Object discovery(){
		//获取微服务列表清单
		List<ServiceInstance> deptprovider_8001 = client.getInstances("DEPTPROVIDER_8001");
		//获取列表中的服务
		for (ServiceInstance instance : deptprovider_8001) {
			instance.getHost();
		}
		return client;
	}
}
