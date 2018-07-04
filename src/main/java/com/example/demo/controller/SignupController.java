package com.example.demo.controller;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;


    private UserDAO userDao;

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String register() {
        return "sighup";
    }

    @RequestMapping(path = "/sighup", method = RequestMethod.POST)
    public String registerAction(ModelMap modelMap,
                                 HttpSession session,
                                 @RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("name") String name,
                                 @RequestParam("sex") String sex,
                                 @RequestParam("homeAddress") String homeAddress,
                                 @RequestParam("telephone") Integer telephone,
                                 @RequestParam("recommender")String recommender,
                                 @RequestParam("industryClub")int industryClub,
                                 @RequestParam("specialCommittee")int specialCommitee
                                 ) {
        User user = userDao.getUserByUsername(username);
        if(user!=null){
            modelMap.addAttribute("message", "用户名已存在");
            return "register";
        }else {
            int uid = userDao.insert(new User(username,password,name,sex,homeAddress,telephone,recommender,industryClub,specialCommitee));
            if(uid<=0){
                modelMap.addAttribute("message", "数据库错误");
                return "register";
            }else{
                session.setAttribute("user",user);
                return "redirect:/index";
            }
        }
    }

    public String getAllStudent(HttpServletRequest request){
        List<User> list = userService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "signup";
    }



}
