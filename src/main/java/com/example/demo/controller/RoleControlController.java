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
public class RoleControlController {
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

    @RequestMapping(value = "/roleControl",method = RequestMethod.GET)
    public String roleQuery(HttpServletRequest request, Model model){
        User user = (User)getSession().getAttribute("usersession");
        if (user == null ) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        if (user.getIsAdmin() == 1) {
            request.setAttribute("user", user);
            List<Proposal> list = studentService.getAllProposal();
            request.setAttribute("proposals",list);
            model.addAttribute("message", "您不是管理员，无法使用高级功能");
            return "query";
        }
        request.setAttribute("user", user);
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
