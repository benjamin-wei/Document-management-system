package com.example.demo.controller;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description
 * @create 2018-07-01
 **/
@Controller
public class Approve2Controller {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/approve2",method = RequestMethod.GET)
    public String approve(HttpServletRequest request){
        List<Proposal> list = studentService.getAllProposal();
        request.setAttribute("proposals",list);
        return "approve2";
    }



}
