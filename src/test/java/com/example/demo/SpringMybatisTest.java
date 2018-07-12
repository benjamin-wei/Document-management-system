package com.example.demo;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath:applicationContext.xml" })
public class SpringMybatisTest {
    @Autowired
    private Service service;

/*    @Autowired
    private User user;*/

/*    @Test
    public void testLogin() {
        //User user = new User();
        user.setUsername("shiyanlou");
        user.setPassword("123456");
        System.out.println(userService.login(user).toString());

    }*/

    @Test
    public void testSelectAllUser() {
        List<User> users = service.getAllUser();
        for (User us : users) {
            System.out.println(us.toString());
        }
    }

/*    @Test
    public void testAdd() {
        //User user = new User();
        user.setUserName("user2");
        user.setPassWord("123456");
        userService.addUser(user);
    }

    @Test
    public void testUpdate() {
        //User user = new User();
        user.setId(3);
        user.setUserName("user2");
        user.setPassWord("123");
        userService.updateUser(user);
    }

    @Test
    public void testUpdate() {
        int id = 3;
        userService.deleteUser(id);
    }*/

}

