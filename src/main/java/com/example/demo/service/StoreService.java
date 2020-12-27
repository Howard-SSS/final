package com.example.demo.service;

import com.example.demo.model.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StoreService {
    //jpa
    List<Store> findAll();
    void deleteById(String fid);
    void save(Store store);
    boolean existsById(String fid);
    Page<Store> findAll(Pageable pageable);
    long count();
    //mybatis
    List<Store> findByColumn(String column, String value);
    List<Store> findByColumns(String column1,String value1,String column2,String value2);
    void insertRow(Store store);
    void updateByFid(String fid,String column,String value);
}
