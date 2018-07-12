package com.example.demo.controller;

import com.example.demo.entity.Referrer;
import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description
 * @create 2018-07-01
 **/
@Controller
public class MaintainController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/maintain",method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model){
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
        List<Referrer> list = studentService.getAllReferrer();
//        if (list == null) {
//            System.out.println("list is null");
//        } else if (list.get(0) == null) {          测试代码
//            System.out.println("list(0) is null");
//        } else {
//            System.out.println(list.get(0).getCompany());
//        }
        request.setAttribute("referrers",list);
        return "maintain";
    }



}
