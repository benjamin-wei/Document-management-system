package com.example.demo.dao;

import com.example.demo.entity.*;
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

    @Select(value = "SELECT * FROM student")
    List<Student> getAllStudent();

    @Select(value = "SELECT * FROM proposal")
    List<Proposal> getAllProposal();

}
