package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.model.mapper.EmpMapper;
import com.study.pojo.Emp;
import com.study.services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

/*
 * @author SMILE.Huang
 * @date 2021-05-13 17:01
 */
@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpServices es;

    @GetMapping
    public PageInfo<Emp>
    selectByPager(@RequestParam(value = "no",defaultValue = "1")Integer no,
                  @RequestParam(value = "size",defaultValue = "10")Integer size){
        return es.selectAll(no,size);
    }

    @GetMapping("add")
    public String addEmp(){
        Emp emp = new Emp(null,"小号","男模",null,new Date(System.currentTimeMillis()),
                2000,null);
        int i = es.doInsert(emp);
        //主键自动生成之后能够注入成功，需要在EmpMapper.xml文件中进行配置
        System.out.println("新增之后："+emp);
        return "新增成功";
    }
}
