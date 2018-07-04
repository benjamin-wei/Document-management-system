package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDAO {

    @Select(value = "SELECT * FROM User")
    List<User> getAllStudent();//查询全部用户

     @Insert("insert into User(name,sex,birth,homeAddress,telephone)values(#{name},#{sex},#{birth},#{homeAddress},#{telephone})")
     int insert(User user);

    @Select("Select * From User Where username=#{username}")
    User getUserByUsername(@Param("username") String username);

    @Select(value="Select *from management where name=#{name} and password=#{password}")
    public User selectLogin(User user);//用户登录



    @Select(value="insert\n" + "into user(username,password,sex,age)\n" + "values(#{username},#{password},#{sex},#{age})\n")
    public void addUser(User user);//新增用户

}
