package com.example.demo;

import com.example.demo.dao.StoreDao;
import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    StoreRepository storeRepository;
    @Resource
    StoreDao storeDao;
    @Test
    void contextLoads() {
        List<Store> list=storeDao.findByColumn("phone","1");
        List<Store> l=new ArrayList<>();

        l.add(list.get(0).setFid("1000"));
        l.add(list.get(1).setFid("1001"));
        storeDao.insertRows(l);
    }

}
