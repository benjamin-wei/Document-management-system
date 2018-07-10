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

    List<Referrer> getAllReferrer();

    List<Comment> getAllComment();

    List<User> getAllUser();

    User getUser(String username);

    Referrer getReferrer(String name);

    Proposal getProposal(int id);

    List<Proposal> getProposalByName(String name);

    List<Comment> getComment(int id);

    boolean insertCon(int id, String name, String content);

    boolean insertPro(String proName, String proWriter,String content);

    boolean userAgree(User user);

    boolean userReject(User user);

    boolean insert(User user);

    boolean verify(User user);

    List<Proposal> getAllProposal();

}
