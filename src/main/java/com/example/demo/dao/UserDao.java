package com.example.demo.dao;

import com.example.demo.model.Store;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user")
    List<Store> findAll();

    @Select("select * from user where ${column} = #{value}")
    Store findByColumn(@Param("column") String column, @Param("value") String value);

    void insertUser(@Param("phone") String phone,@Param("user1") String user1,@Param("password") String password);

    @Delete("delete from user where phone = #{phone}")
    void deleteByPhone(@Param("phone") String phone);

    @Update("update user set ${column} = #{value} where phone = #{phone}")
    void updateByPhone(@Param("phone") String phone,@Param("column") String column,@Param("value") String value);
}
