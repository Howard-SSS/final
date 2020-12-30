package com.example.demo;

import com.example.demo.dao.StoreDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Store;
import com.example.demo.model.User;
import com.example.demo.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    UserDao userDao;
    @Test
    void contextLoads() {
        User user=new User();
        user.setName("123");
        user.setPassword("123");
        user.setPhone("123");
        userDao.insertUser(user);
    }

}
