package com.example.demo.controller;

import com.example.demo.entity.Proposal;
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
public class ApproveController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/approve",method = RequestMethod.GET)
    public String approve(HttpServletRequest request, Model model){
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
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
        if (!user.getAssoName().equals("专委会")) {
            model.addAttribute("message", "您不是专委会会员，无法使用该功能");
            request.setAttribute("user", user);
            List<Proposal> list = studentService.getAllProposal();
            request.setAttribute("proposals",list);
            return "query";
        }
        request.setAttribute("user", user);
        List<Proposal> list = studentService.getAllProposal();
        request.setAttribute("proposals",list);
        return "approve";
    }



}
