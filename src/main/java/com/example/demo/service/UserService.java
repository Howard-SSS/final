package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findByColumn(String column,String value);
    List<User> findByColumns(User user);
    void insertRow(User user);
    void deleteByPhone(String phone);
    void updateByPhone(String phone,String column,String value);
}

