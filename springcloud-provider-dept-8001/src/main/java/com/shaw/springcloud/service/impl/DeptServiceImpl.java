package com.shaw.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaw.springcloud.mapper.DeptMapper;
import com.shaw.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import com.shaw.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
* @author sky
* @description 针对表【dept(部门表)】的数据库操作Service实现
* @createDate 2022-11-07 13:23:58
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService {

	@Resource
	private DeptMapper deptMapper;


	@Override
	public List<Dept> listall() {
		return deptMapper.listall();
	}
}




