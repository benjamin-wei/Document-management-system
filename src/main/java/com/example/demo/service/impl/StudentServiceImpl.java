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

    public List<Proposal> getAllProposal() {return studentDAO.getAllProposal();}

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
