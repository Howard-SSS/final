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

    void insertRow(Store store);

    void insertRows(List<Store> stores);

    @Delete("delete from store where fid = #{fid}")
    void deleteByFid(@Param("fid") String fid);

    @Update("update store set ${column} = #{value} where fid = #{fid}")
    void updateByFid(@Param("fid") String fid,@Param("column") String column,@Param("value") String value);

    void updateColumns(Store store);
}
