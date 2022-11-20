package com.shaw.springcloud.service;

import com.shaw.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "DEPTPROVIDER",fallbackFactory = DeptClientServiceFallBackFactory.class)
//value是服务的名字
@Component
public interface DeptClientService {

	@GetMapping("/dept/list")
	public List<Dept> listall();

}
