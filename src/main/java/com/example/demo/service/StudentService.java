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

    List<Comment> getAllComment();

    List<User> getAllUser();

    User getUser(String name);

    Proposal getProposal(int id);

    List<Comment> getComment(int id);

    boolean insertCon(int id, String content);

    boolean insert(User user);

    boolean verify(User user);

    List<Proposal> getAllProposal();

}
