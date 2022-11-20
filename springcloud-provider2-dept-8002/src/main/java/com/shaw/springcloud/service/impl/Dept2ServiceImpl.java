package com.shaw.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaw.springcloud.pojo.Dept;

import com.shaw.springcloud.service.Dept2Service;
import com.shaw.springcloud.mapper.Dept2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author sky
* @description 针对表【dept2(部门表)】的数据库操作Service实现
* @createDate 2022-11-13 13:24:53
*/
@Service
public class Dept2ServiceImpl extends ServiceImpl<Dept2Mapper, Dept>
    implements Dept2Service{

	@Resource
	Dept2Mapper dept2Mapper;

	@Override
	public List<Dept> listall() {
		return  dept2Mapper.listall();
	}
}




