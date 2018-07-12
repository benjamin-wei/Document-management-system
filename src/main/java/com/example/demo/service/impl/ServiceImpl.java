package com.example.demo.service.impl;

import com.example.demo.controller.PasswordHash;
import com.example.demo.dao.DAO;
import com.example.demo.entity.*;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    private DAO DAO;

    public List<Proposal> getProposalByName(String name) {return DAO.getProposalByName(name);}

    public List<Referrer> getAllReferrer() {return DAO.getAllReferrer();}

    public List<User> getAllUser() {return DAO.getAllUser();}

    public List<Proposal> getAllProposal() {return DAO.getAllProposal();}

    public List<Comment> getAllComment() {return DAO.getAllComment();}

    @Override
    public Proposal getProposal(int id) {
        return DAO.getProposal(id);
    }

    @Override
    public User getUser(String username) {
        return DAO.getUser(username);
    }

    @Override
    public Referrer getReferrer(String name) {
        return DAO.getReferrer(name);
    }

    @Override
    public List<Comment> getComment(int id) {
        return DAO.getComment(id);
    }

    @Override
    public boolean insert(User user) {
        if (null == user){
            return false;
        }
        // do something...
        DAO.insert(user);
        return true;
    }

    @Override
    public boolean insertCon(int id, String name, String content) {
        if (null == name || null == content || id == 0){
            return false;
        }
        // do something...
        DAO.insertCon(id, name, content);
        return true;
    }

    @Override
    public  boolean userAgree(User user) {
        if (user == null) {
            return false;
        }
        DAO.userAgree(user);
        return true;
    }

    @Override
    public  boolean userReject(User user) {
        if (user == null) {
            return false;
        }
        DAO.userReject(user);
        return true;
    }

    @Override
    public boolean insertPro(String proName, String proWriter,String content) {
        if (null == proName || null == content || null == proWriter){
            return false;
        }
        // do something...
        DAO.insertPro(proName,proWriter,content);
        return true;
    }

    @Override
    public boolean insertRef(Referrer referrer) {
        if (null == referrer){
            return false;
        }
        // do something...
        DAO.insertRef(referrer);
        return true;
    }

    @Override
    public boolean verify(User user) {
        User userreturn = DAO.verify(user);
        if (userreturn == null) {
            return false;
        }
        try {
            if (PasswordHash.validatePassword(user.getPassWord(), userreturn.getPassWord())){
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return false;
    }
}
