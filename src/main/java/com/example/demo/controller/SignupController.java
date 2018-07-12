package com.example.demo.controller;

import com.example.demo.entity.*;
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
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Controller
public class SignupController {
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

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @RequestMapping(value = "/user/insert",method = RequestMethod.GET)
    public String insert(@ModelAttribute("user") User user, Model model){
        User user2 = (User)getSession().getAttribute("usersession");
        model.addAttribute("message", "注册成功！请耐心等待审核");
        try {
            user.setPassWord(PasswordHash.createHash(user.getPassWord()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        studentService.insert(user);
        return "Login";
    }

}
