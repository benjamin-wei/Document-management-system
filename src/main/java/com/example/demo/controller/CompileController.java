package com.example.demo.controller;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
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
public class CompileController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/compile",method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model){
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
        List<Proposal> list = studentService.getProposalByName(user.getName());
        request.setAttribute("proposals", list);
        return "compile";
    }

    @RequestMapping(value = "/proposal/insert",method = RequestMethod.GET)
    public String insert(@ModelAttribute("proposal") Proposal proposal, HttpServletRequest request, Model model) {
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        request.setAttribute("user", user);
        String proName = proposal.getProName();
        String proWriter = user.getName();
        String content = proposal.getContent();
        studentService.insertPro(proName,proWriter,content);
        List<Proposal> proposals = studentService.getProposalByName(user.getName());
        request.setAttribute("proposals", proposals);
        return "compile";
    }
}
