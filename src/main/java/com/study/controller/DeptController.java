package com.study.controller;

import com.study.pojo.Dept;
import com.study.services.DeptServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @author SMILE.Huang
 * @date 2021-05-13 16:09
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptServices ds;
    @GetMapping
    public String init(){
        return "<a href='/dept/20'>根据主键查询信息</a><a href='/dept/pager'>分页查询</a>";
    }

    @GetMapping("/{did}")
    public Dept selectById(@PathVariable("did") Integer deptno){
        //springboot响应主体，json序列化结果的时候会自动把关系字段循环读取出来，需要在关系字段上设置@JsonIgnore
        return ds.findById(deptno);
    }

    @GetMapping("pager")
    public List<Dept> selectByPager(@RequestParam(value = "no",defaultValue = "1") Integer no,
                                    @RequestParam(value = "size",defaultValue = "10")Integer size){
        return ds.selectByKeyWord("A",no,size);
    }
}
