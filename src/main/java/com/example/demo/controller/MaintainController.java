package com.example.demo.controller;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.Referrer;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class MaintainController {
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

    @RequestMapping(value = "/maintain",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        User user = (User)getSession().getAttribute("usersession");
        if (user == null) {
            return "redirect:/Login";
        }
        request.setAttribute("user", user);
        List<Referrer> list = studentService.getAllReferrer();
        if (list == null) {
            System.out.println("list is null");
        } else if (list.get(0) == null) {
            System.out.println("list(0) is null");
        } else {
            System.out.println(list.get(0).getCompany());
        }
        request.setAttribute("referrers",list);
        return "maintain";
    }



}
