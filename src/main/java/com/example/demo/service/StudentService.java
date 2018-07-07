package com.example.demo.service;

import com.example.demo.entity.*;

import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/

public interface StudentService {

    List<Student> getAllStudent();

    boolean insert(User user);

    boolean verify(User user);

    List<Proposal> getAllProposal();

}
