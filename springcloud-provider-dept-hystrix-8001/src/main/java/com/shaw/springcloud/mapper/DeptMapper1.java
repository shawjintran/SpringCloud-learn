package com.shaw.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaw.springcloud.pojo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author sky
* @description 针对表【dept(部门表)】的数据库操作Mapper
* @createDate 2022-11-07 13:23:58
* @Entity com.shaw.springcloud.pojo.Dept
*/
@Mapper
public interface DeptMapper1 extends BaseMapper<Dept> {
	 List<Dept> listall();

	 Dept get(Long id);
}




