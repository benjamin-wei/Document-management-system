package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description
 * @create 2018-07-01
 **/
@Controller
public class QueryController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public String query(HttpServletRequest request){
        List<Proposal> list = studentService.getAllProposal();
        request.setAttribute("proposals",list);
        return "query";
    }

    @RequestMapping(value = "/user/insert",method = RequestMethod.GET)
    public String insert(@ModelAttribute("user") User user, Model model){
        studentService.insert(user);
        return "redirect:/Login";
    }



}
