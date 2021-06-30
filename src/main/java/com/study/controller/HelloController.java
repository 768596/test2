package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author SMILE.Huang
 * @date 2021-05-13 14:59
 */
@RestController  /*@Controller+@ResponseBody  该controller一律不跳页面*/
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hello(){
        return "你好呀，Spring Boot";
    }
}
