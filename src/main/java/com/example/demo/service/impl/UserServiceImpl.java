package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Store;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao UserDao;
    @Override
    public List<Store> findAll() {
        return UserDao.findAll();
    }

    @Override
    public Store findByColumn(String column, String value) {
        return UserDao.findByColumn(column,value);
    }

    @Override
    public void insertRow(String phone, String name, String password) {
        UserDao.insertUser(phone,name,password);
    }

    @Override
    public void deleteByPhone(String phone) {
        UserDao.deleteByPhone(phone);
    }

    @Override
    public void updateByPhone(String phone, String column, String value) {
        UserDao.updateByPhone(phone,column,value);
    }
}
