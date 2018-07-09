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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description
 * @create 2018-07-01
 **/
@Controller
public class CheckApplyController {
    //1.获取当前上下文对应的request请求
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
    }
    //2.获取request请求中包含的session对象
    public static HttpSession getSession(){
        HttpSession session = null;
        try{
            session = getRequest().getSession();
        }catch (Exception e){
        }
        return session;
    }

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/checkApply", method = RequestMethod.GET)
    public String checkApply(@ModelAttribute("username") String username, HttpServletRequest request, Model model) {
        User user = (User)getSession().getAttribute("usersession");
        if (user == null) {
            return "redirect:/Login";
        }
        request.setAttribute("user", user);
        User user2 = studentService.getUser(username);
        Referrer referrer = studentService.getReferrer(user.getReferrer());
        request.setAttribute("name", user.getName());  /*传user属性给页面*/
        request.setAttribute("gender", user.getGender());
        request.setAttribute("birthday", user.getBirthday());
        request.setAttribute("address", user.getAddress());
        request.setAttribute("conWay", user.getConWay());
        request.setAttribute("referrer", user.getReferrer());
        request.setAttribute("assoName", user.getAssoName());
        request.setAttribute("referrer", referrer); /*传referrer属性给页面*/
        return "checkApply";
    }

}
