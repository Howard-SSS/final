package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where ${column} = #{value}")
    List<User> findByColumn(@Param("column") String column, @Param("value") String value);

    List<User> findByColumns(User user);

    void insertUser(User user);

    @Delete("delete from user where phone = #{phone}")
    void deleteByPhone(@Param("phone") String phone);

    @Update("update user set ${column} = #{value} where phone = #{phone}")
    void updateByPhone(@Param("phone") String phone,@Param("column") String column,@Param("value") String value);
}
