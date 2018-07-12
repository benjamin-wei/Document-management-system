package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @create 2018-07-01
 **/
@Controller
public class CheckApplyController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/checkApply", method = RequestMethod.GET)
    public String checkApply(@ModelAttribute("username") String username, HttpServletRequest request, Model model) {
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
        User user2 = service.getUser(username);
        Referrer referrer = service.getReferrer(user.getReferrer());
        request.setAttribute("name", user2.getName());  /*传user属性给页面*/
        request.setAttribute("username", user2.getUserName());
        request.setAttribute("gender", user2.getGender());
        request.setAttribute("birthday", user2.getBirthday());
        request.setAttribute("address", user2.getAddress());
        request.setAttribute("conWay", user2.getConWay());
        request.setAttribute("referrer", user2.getReferrer());
        request.setAttribute("assoName", user2.getAssoName());
        request.setAttribute("user2", user2);
        request.setAttribute("referrer", referrer); /*传referrer属性给页面*/
        return "checkApply";
    }

    @RequestMapping(value = "/user/agree", method = RequestMethod.GET)
    public String userAgree(@ModelAttribute("username") String username, HttpServletRequest request, Model model) {
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
        User user2 = service.getUser(username);
        service.userAgree(user2);
        request.setAttribute("users",RoleControlController.nobody(service));
        return "roleControl";
    }

    @RequestMapping(value = "/user/reject", method = RequestMethod.GET)
    public String userReject(@ModelAttribute("username") String username, HttpServletRequest request, Model model) {
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
        User user2 = service.getUser(username);
        service.userReject(user2);
        request.setAttribute("users",RoleControlController.nobody(service));
        return "roleControl";
    }

}
