package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Store;
import com.example.demo.service.StoreService;
import org.hibernate.sql.OracleJoinFragment;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StoreController {
    @Resource
    StoreService storeService;

    @RequestMapping("/toManage")
    public String toManage(){
        return "manage";
    }

    @RequestMapping("/save")
    public String  toSavePage(Model model){
        return "save";
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
            deleteByFid(list.get(i).getSid());
        }
    }

    @RequestMapping("/addStore")
    @ResponseBody
    public String addRow(String json){
        Store store= JSONObject.parseObject(json,Store.class);
        if(storeService.existsById(store.getSid())){
            return "is exists primaryKey";
        }
        storeService.save(store);
        return "success";
    }
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam( value = "file") MultipartFile file) throws IOException {
        File f=new File("E:/移动应用开发/Bitmap/"+file.getOriginalFilename());
        file.transferTo(f);
        Map map = new HashMap<String, Object>();
        map.put("path",f.getPath());
        return map;
    }
}
