package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.EmpMapper;
import com.study.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @author SMILE.Huang
 * @date 2021-05-13 16:55
 */
@Service
public class EmpServices {
    @Autowired
    private EmpMapper mapper;

    /**分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Emp> selectAll(Integer pageNo,Integer pageSize){
//        com.github.pagehelper.PageHelper
        PageHelper.startPage(pageNo,pageSize);
        List<Emp> list = mapper.selectAll();
        PageInfo<Emp> pageInfo = PageInfo.of(list);
        return pageInfo;
    }

    public Integer doInsert(Emp emp){
        System.out.println("新增前的实体类："+emp);
        return mapper.doInsert(emp);
    }
}
