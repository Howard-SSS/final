package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Store;
import com.example.demo.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StoreController {
    @Resource
    StoreService storeService;

    @RequestMapping("/toManage")
    public String toManage(){
        return "manage";
    }
    @RequestMapping("/loadData")
    @ResponseBody
    public List<Store> load(){
        return storeService.findAll();
    }

    @RequestMapping("/deleteRow")
    @ResponseBody
    public void deleteByFid(String fid){
        storeService.deleteById(fid);
    }
    @RequestMapping("/deleteRows")
    @ResponseBody
    public void deleteRows(String json){
        List<Store> list= JSON.parseArray(json,Store.class);
        for(int i=0;i<list.size();i++){
            deleteByFid(list.get(i).getFid());
        }
    }

    @RequestMapping("/addRow")
    @ResponseBody
    public String addRow(String json){
        Store store= JSONObject.parseObject(json,Store.class);
        if(storeService.existsById(store.getFid())){
            return "is exists primaryKey";
        }
        storeService.save(store);
        return "success";
    }
    @RequestMapping("/save")
    public String  toSavePage(Model model){
        return "save";
    }
}
