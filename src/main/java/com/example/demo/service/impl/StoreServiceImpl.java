package com.example.demo.service.impl;

import com.example.demo.dao.StoreDao;
import com.example.demo.model.Store;
//import com.example.demo.repository.StoreRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Resource
    StoreRepository storeRepository;
    @Resource
    StoreDao storeDao;

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public void deleteById(String fid) {
        storeRepository.deleteById(fid);
    }

    @Override
    public void save(Store store) {
        storeRepository.save(store);
    }

    @Override
    public boolean existsById(String fid) {
        return storeRepository.existsById(fid);
    }

    @Override
    public List<Store> findByColumn(String column, String value) {
        return storeDao.findByColumn(column,value);
    }

    @Override
    public List<Store> findByColumns(String column1, String value1, String column2, String value2) {
        return storeDao.findByColumns(column1,value1,column2,value2);
    }

    @Override
    public void insertRow(Store store) {
        storeDao.insertRow(store);
    }

    @Override
    public void updateByFid(String fid,String column,String value) {
        storeDao.updateByFid(fid,column,value);
    }
}
