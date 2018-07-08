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
public class CheckApplyController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/checkApply", method = RequestMethod.GET)
    public String checkApply(@ModelAttribute("name") String name, HttpServletRequest request, Model model) {
        User user = studentService.getUser(name);
        request.setAttribute("name", user.getName());
        request.setAttribute("gender", user.getGender());
        request.setAttribute("birthday", user.getBirthday());
        request.setAttribute("address", user.getAddress());
        request.setAttribute("conWay", user.getConWay());
        request.setAttribute("referrer", user.getReferrer());
        request.setAttribute("assoName", user.getAssoName());
        return "checkApply";
    }

}
