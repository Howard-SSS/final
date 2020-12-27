package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/login")
    @ResponseBody
    public void login(){

    }
    @RequestMapping("/register")
    @ResponseBody
    public void register(String json){
        User user= JSON.parseObject(json,User.class);
        userService.insertRow(user.getPhone(),user.getName(),user.getPassword());
    }
}
