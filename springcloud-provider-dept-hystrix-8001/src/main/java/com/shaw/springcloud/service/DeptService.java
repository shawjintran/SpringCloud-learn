package com.shaw.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shaw.springcloud.pojo.Dept;

import java.util.List;

/**
* @author sky
* @description 针对表【dept(部门表)】的数据库操作Service
* @createDate 2022-11-07 13:23:58
*/
public interface DeptService extends IService<Dept> {
	 List<Dept> listall();

	Dept get(Long id);
}
