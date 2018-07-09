package com.example.demo.service.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.*;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.getAllStudent();
    }

    public List<Proposal> getProposalByName(String name) {return studentDAO.getProposalByName(name);}

    public List<Referrer> getAllReferrer() {return studentDAO.getAllReferrer();}

    public List<User> getAllUser() {return studentDAO.getAllUser();}

    public List<Proposal> getAllProposal() {return studentDAO.getAllProposal();}

    public List<Comment> getAllComment() {return studentDAO.getAllComment();}

    @Override
    public Proposal getProposal(int id) {
        return studentDAO.getProposal(id);
    }

    @Override
    public User getUser(String username) {
        return studentDAO.getUser(username);
    }

    @Override
    public Referrer getReferrer(String name) {
        return studentDAO.getReferrer(name);
    }

    @Override
    public List<Comment> getComment(int id) {
        return studentDAO.getComment(id);
    }

    @Override
    public boolean insert(User user) {
        if (null == user){
            return false;
        }
        // do something...
        studentDAO.insert(user);
        return true;
    }

    @Override
    public boolean insertCon(int id, String name, String content) {
        if (null == name || null == content || id == 0){
            return false;
        }
        // do something...
        studentDAO.insertCon(id, name, content);
        return true;
    }

    @Override
    public boolean insertPro(String proName, String proWriter,String content) {
        if (null == proName || null == content || null == proWriter){
            return false;
        }
        // do something...
        studentDAO.insertPro(proName,proWriter,content);
        return true;
    }

    @Override
    public boolean verify(User user) {
        User userreturn = studentDAO.verify(user);
        if (userreturn == null) {
            return false;
        }
        if (userreturn.getPassWord().equals(user.getPassWord())){
            return true;
        }
        return false;
    }
}
