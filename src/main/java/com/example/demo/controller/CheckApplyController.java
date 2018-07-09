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
import java.util.ArrayList;
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
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
        User user2 = studentService.getUser(username);
        Referrer referrer = studentService.getReferrer(user.getReferrer());
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
        User user = (User)getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
        User user2 = studentService.getUser(username);
        studentService.userAgree(user2);
        Referrer referrer = studentService.getReferrer(user.getReferrer());
        request.setAttribute("name", user.getName());  /*传user属性给页面*/
        request.setAttribute("gender", user.getGender());
        request.setAttribute("birthday", user.getBirthday());
        request.setAttribute("address", user.getAddress());
        request.setAttribute("conWay", user.getConWay());
        request.setAttribute("referrer", user.getReferrer());
        request.setAttribute("assoName", user.getAssoName());
        request.setAttribute("referrer", referrer); /*传referrer属性给页面*/
        List<User> userlist = studentService.getAllUser();
        List<User> nobody = new ArrayList<>();         //终于写上稍微有点技术含量（正经）的java代码了……
        for (User u: userlist) {
            if (u.getIsAdmin() == 0) {
                nobody.add(u);
            }
        }
        request.setAttribute("users",nobody);
        return "roleControl";
    }

    @RequestMapping(value = "/user/reject", method = RequestMethod.GET)
    public String userReject(@ModelAttribute("username") String username, HttpServletRequest request, Model model) {
        User user = (User)getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
        User user2 = studentService.getUser(username);
        studentService.userReject(user2);
        Referrer referrer = studentService.getReferrer(user.getReferrer());
        request.setAttribute("name", user.getName());  /*传user属性给页面*/
        request.setAttribute("gender", user.getGender());
        request.setAttribute("birthday", user.getBirthday());
        request.setAttribute("address", user.getAddress());
        request.setAttribute("conWay", user.getConWay());
        request.setAttribute("referrer", user.getReferrer());
        request.setAttribute("assoName", user.getAssoName());
        request.setAttribute("referrer", referrer); /*传referrer属性给页面*/
        List<User> userlist = studentService.getAllUser();
        List<User> nobody = new ArrayList<>();         //终于写上稍微有点技术含量（正经）的java代码了……
        for (User u: userlist) {
            if (u.getIsAdmin() == 0) {
                nobody.add(u);
            }
        }
        request.setAttribute("users",nobody);
        return "roleControl";
    }

}
