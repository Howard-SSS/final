package com.example.demo.dao;

import com.example.demo.model.Store;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreDao {

    @Select("select * from store")
    List<Store> findAll();

    @Select("select * from store where ${column} = #{value}")
    List<Store> findByColumn(@Param("column") String column, @Param("value") String value);

    List<Store> findByColumns(Store store);

    void insertStore(Store store);

    void insertStores(List<Store> stores);

    @Delete("delete from store where sid = #{sid}")
    void deleteBySid(@Param("sid") String sid);

    @Update("update store set ${column} = #{value} where sid = #{sid}")
    void updateBySid(@Param("sid") String sid,@Param("column") String column,@Param("value") String value);

    void updateColumns(Store store);
}
