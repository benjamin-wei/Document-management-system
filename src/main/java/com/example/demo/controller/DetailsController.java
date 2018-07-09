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
public class DetailsController {
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

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String query(@Param("id") @ModelAttribute("id")  int id, HttpServletRequest request, Model model) {
        User user = (User)getSession().getAttribute("usersession");
        if (user == null) {
            return "Login";
        }
        request.setAttribute("user", user);
//        List<Comment> list = studentService.getAllComment();
//        request.setAttribute("comments",list);
//        if (id == 0) {
//            Proposal proposal = (Proposal) getSession().getAttribute("proposalsession");
//            id = proposal.getId();
//            List<Comment> list = studentService.getComment(id);
//            request.setAttribute("comments", list);
//            request.setAttribute("proposal", proposal);
//        } else {
            Proposal proposal = studentService.getProposal(id);
            List<Comment> list = studentService.getComment(id);
            request.setAttribute("comments", list);
            request.setAttribute("proposal", proposal);
            request.getSession().setAttribute("proposalsession",proposal);
//        }
//        List<Comment> list = studentService.getComment(id);
//        request.setAttribute("comments", list);
//        request.setAttribute("proposal", proposal);
//        request.setAttribute("id", proposal.getId());
//        request.setAttribute("name",proposal.getProName());
//        request.setAttribute("writer",proposal.getProWriter());
//        request.setAttribute("deadline",proposal.getDeadline());
//        request.setAttribute("content",proposal.getContent());
//        request.getSession().setAttribute("proposalsession",proposal);

        return "details";
    }

    @RequestMapping(value = "/comment/insert",method = RequestMethod.GET)
    public String insert(@ModelAttribute("comment")  Comment comment, HttpServletRequest request, Model model){
        User user = (User)getSession().getAttribute("usersession");
        if (user == null) {
            return "redirect:/Login";
        }
        request.setAttribute("user", user);
//        int id = request.getParameter("id");
//        String content = request.getParameter("content");
//        User user = (User)getSession().getAttribute("usersession");
        Proposal proposal = (Proposal) getSession().getAttribute("proposalsession");
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
