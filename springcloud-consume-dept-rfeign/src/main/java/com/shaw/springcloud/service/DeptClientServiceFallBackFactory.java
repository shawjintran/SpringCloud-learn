package com.shaw.springcloud.service;

import com.shaw.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
	@Override
	public DeptClientService create(Throwable throwable) {
		return  new DeptClientService() {
			@Override
			public List<Dept> listall() {
				ArrayList<Dept> list = new ArrayList<>();
				list.add(new Dept().setDname("服务已中断"));
				return list;
			}
		};
	}
}
