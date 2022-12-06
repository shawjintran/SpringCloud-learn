package com.shaw.springcloud.Controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shaw.springcloud.configuration.PatternProperties;
import com.shaw.springcloud.pojo.Dept;
import com.shaw.springcloud.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/dept")
@RestController
@Slf4j
@RefreshScope
public class DeptController {
	@Autowired
	private DeptService deptService;

	// @Value("${pattern.dateformat}")
	// private String dateformate;

	@Autowired
	private PatternProperties patternProperties;

	@Autowired
	private DiscoveryClient client;
	static final String UPL_PERFIX="http://DeptProvider";


	//直接通过RPC 联系服务提供者
	@Autowired
	RestTemplate restTemplate;
	//提供多种便捷访问远程http服务的方法,简单的RestFul服务

	@GetMapping("now")
	public String now(){
		// return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformate));
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
	}
	@GetMapping("/list")
	public List<Dept> list(){
		System.out.println("yes");
		return restTemplate.getForObject(UPL_PERFIX+"/dept/list",List.class);
	}
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
