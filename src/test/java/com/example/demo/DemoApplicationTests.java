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
        Store store=new Store();
        store.setFid("1");
        store.setPhone("2");
        storeDao.updateColumns(store);
    }

}
