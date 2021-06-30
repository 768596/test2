package com.study.model.mapper;

import com.study.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> selectAll();//查询所有

    Emp selectById(Integer eid);//根据主键查询

    Integer doInsert(Emp emp);//自增
}
