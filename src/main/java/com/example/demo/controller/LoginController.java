package com.example.demo.controller;

import com.example.demo.entity.*;
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
public class LoginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user",new User());
        return "Login";
    }

    @RequestMapping(value = "/login/verify",method = RequestMethod.GET)
    public String verify(@ModelAttribute("user") User user, Model model){
        Boolean isUser = studentService.verify(user);
        if (isUser.equals(true)) {
            return "redirect:/query";
        }
        model.addAttribute("message", "用户名或密码错误，请重试！");
        return "Login";
    }



}
