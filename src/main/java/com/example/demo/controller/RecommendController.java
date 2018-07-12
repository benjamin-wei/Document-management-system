package com.example.demo.controller;

import com.example.demo.entity.Referrer;
import com.example.demo.entity.User;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RecommendController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/recommend",method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model){
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        return "recommend";
    }

    @RequestMapping(value = "/referrer/insert",method = RequestMethod.GET)
    public String login(@ModelAttribute("referrer") Referrer referrer, HttpServletRequest request, Model model){
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        service.insertRef(referrer);
        List<Referrer> list = service.getAllReferrer();
        request.setAttribute("referrers",list);
        return "maintain";
    }



}
