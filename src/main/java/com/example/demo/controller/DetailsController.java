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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description
 * @create 2018-07-01
 **/
@Controller
public class DetailsController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String query(@Param("id") @ModelAttribute("id")  int id, HttpServletRequest request, Model model) {
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
            Proposal proposal = studentService.getProposal(id);
            List<Comment> list = studentService.getComment(id);
            request.setAttribute("comments", list);
            request.setAttribute("proposal", proposal);
            request.getSession().setAttribute("proposalsession",proposal);

        return "details";
    }

    @RequestMapping(value = "/comment/insert",method = RequestMethod.GET)
    public String insert(@ModelAttribute("comment")  Comment comment, HttpServletRequest request, Model model){
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
//        int id = request.getParameter("id");         //另一种写法
//        String content = request.getParameter("content");
        Proposal proposal = (Proposal) QueryController.getSession().getAttribute("proposalsession");
        int id =proposal.getId();
        String content = comment.getContent();
        String name = user.getName();
        studentService.insertCon(id,name,content);
        List<Comment> list = studentService.getComment(id);
        request.setAttribute("comments", list);
        request.setAttribute("proposal", proposal);
        return "details";
    }
}
