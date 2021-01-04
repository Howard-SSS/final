package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Store;
import com.example.demo.model.User;
import com.example.demo.service.StoreService;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    StoreService storeService;
    @Resource
    UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toIndex")
    public String toIndex(@RequestParam(value = "index",required = false,defaultValue = "0") int index, Model model){
        long num=storeService.count();
        long page= num/12+1;
        PageRequest pageRequest=PageRequest.of(index, 12);
        Page<Store> list=storeService.findAll(pageRequest);
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        return "index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String json){
        User user= JSON.parseObject(json,User.class);
        List<User> ret=userService.findByColumns(user);
        if(ret.size()<0)
            return "fail";
        else if(ret.get(0).getName().equals("administrator"))
            return "administrator";
        return "common";
    }

    @RequestMapping("/register")
    @ResponseBody
    public void register(String json){
        User user= JSON.parseObject(json,User.class);
        userService.insertRow(user);
    }
}
