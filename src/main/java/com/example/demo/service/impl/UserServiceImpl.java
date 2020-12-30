package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao UserDao;
    @Override
    public List<User> findAll() {
        return UserDao.findAll();
    }

    @Override
    public List<User> findByColumn(String column, String value) {
        return UserDao.findByColumn(column,value);
    }

    @Override
    public List<User> findByColumns(User user) {
        return UserDao.findByColumns(user);
    }

    @Override
    public void insertRow(User user) {
        UserDao.insertUser(user);
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
