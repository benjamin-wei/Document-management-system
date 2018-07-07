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
    public String query(@ModelAttribute("id")  int id, @ModelAttribute("proName")  String proName, @ModelAttribute("proWriter")  String proWriter, @ModelAttribute("deadline")  int deadline, @ModelAttribute("status")  String status, @ModelAttribute("agree")  int agree, @ModelAttribute("oppose")  int oppose, @ModelAttribute("content")  String content, HttpServletRequest request, Model model) {
//        List<Proposal> list = studentService.getAllProposal();
//        request.setAttribute("proposals", list);
        request.setAttribute("id", id);
        request.setAttribute("proName", proName);
        request.setAttribute("proWriter", proWriter);
        request.setAttribute("deadline", deadline);
        request.setAttribute("status", status);
        request.setAttribute("agree", agree);
        request.setAttribute("oppose", oppose);
        request.setAttribute("content", content);
        return "details";
    }
}
