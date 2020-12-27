package com.example.demo.repository;

import com.example.demo.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,String> {
    List<Store> findByName(String name);
    List<Store> findByPhone(String phone);
    List<Store> findByAddress(String address);
    List<Store> findByIntroduce(String introduce);
    List<Store> findByPicture(String picture);
}
