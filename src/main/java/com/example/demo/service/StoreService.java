package com.example.demo.service;

import com.example.demo.model.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StoreService {
    //jpa
    List<Store> findAll();
    void deleteById(String sid);
    void save(Store store);
    boolean existsById(String sid);
    Page<Store> findAll(Pageable pageable);
    long count();
    //mybatis
    List<Store> findByColumn(String column, String value);
    List<Store> findByColumns(Store store);
    void insertRow(Store store);
    void insertRows(List<Store> stores);
    void updateBySid(String sid,String column,String value);
    void updateColumns(Store store);
}
