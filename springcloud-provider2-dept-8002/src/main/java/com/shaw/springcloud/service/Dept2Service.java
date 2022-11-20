package com.shaw.springcloud.service;

import com.shaw.springcloud.pojo.Dept;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author sky
* @description 针对表【dept2(部门表)】的数据库操作Service
* @createDate 2022-11-13 13:24:53
*/
public interface Dept2Service extends IService<Dept> {
	List<Dept> listall();
}
