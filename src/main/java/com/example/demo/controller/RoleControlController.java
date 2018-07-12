package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @create 2018-07-01
 **/
@Controller
public class RoleControlController {

    @Autowired
    private Service service;

    public static List<User> nobody(Service service) {
        List<User> userlist = service.getAllUser();
        List<User> nobody = new ArrayList<>();
        for (User u: userlist) {
            if (u.getIsAdmin() == 0) {
                nobody.add(u);
            }
        }
        return nobody;
    }

    @RequestMapping(value = "/roleControl",method = RequestMethod.GET)
    public String roleQuery(HttpServletRequest request, Model model){
        User user = (User)QueryController.getSession().getAttribute("usersession");
        if (user == null ) {
            model.addAttribute("message", "登陆已过期，请重新登陆");
            model.addAttribute("user",new User());
            return "Login";
        }
        if (user.getIsAdmin() == 1) {
            request.setAttribute("user", user);
            List<Proposal> list = service.getAllProposal();
            request.setAttribute("proposals",list);
            model.addAttribute("message", "您不是管理员，无法使用高级功能");
            return "query";
        }
        request.setAttribute("user", user);
        request.setAttribute("users",nobody(service));
        return "roleControl";
    }

}
