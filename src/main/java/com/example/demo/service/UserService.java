package com.example.demo.service;

import com.example.demo.model.Store;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {
    List<Store> findAll();

    Store findByColumn(String column,String value);

    void insertRow(String phone,String name,String password);

    void deleteByPhone(@Param("phone") String phone);

    void updateByPhone(@Param("phone") String phone,@Param("column") String column,@Param("value") String value);
}

