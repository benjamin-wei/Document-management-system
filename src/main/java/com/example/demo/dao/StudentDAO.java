package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description
 * @author Tim Lin
 * @create 2018-07-01
 **/
@Mapper
public interface StudentDAO {

    @Select(value="Select *from student where name=#{name} and password=#{password}")
    public Student selectLogin(Student student);//用户登录

    @Select(value = "SELECT * FROM student")
    List<Student> getAllStudent();//查询全部用户

    @Select(value="insert\n" + "into user(username,password,sex,age)\n" + "values(#{username},#{password},#{sex},#{age})\n")
    public void addUser(Student student);//新增用户

}
