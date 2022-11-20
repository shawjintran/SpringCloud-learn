package com.shaw.springcloud.mapper;

import com.shaw.springcloud.pojo.Dept;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author sky
* @description 针对表【dept2(部门表)】的数据库操作Mapper
* @createDate 2022-11-13 13:24:53
* @Entity com.shaw.springcloud.pojo.Dept2
*/
@Mapper
public interface Dept2Mapper extends BaseMapper<Dept> {
	List<Dept> listall();
}




