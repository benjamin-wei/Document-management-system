package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.StudentService;
import org.apache.ibatis.annotations.Param;
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
public class DetailsController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String query(@ModelAttribute("id")  int id, @ModelAttribute("comment")  String comment,HttpServletRequest request, Model model) {
//        List<Comment> list = studentService.getAllComment();
//        request.setAttribute("comments",list);
        List<Comment> list = studentService.getComment(id);
        request.setAttribute("comments", list);
        Proposal proposal = studentService.getProposal(id);
        request.setAttribute("proposal", proposal);
        return "details";
    }
}
