package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {

    private User user;
    private Draft draft;
    @Test
    public void contextLoads() {
    }

    @Test
    public void SignUpTest(){
        //User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setBirthday("1997 1 1");
        user.setAddress("beijing");
        user.setPhoneNO("111111111");
        user.setRecommand("李四");
        user.setBusiness("abcd");
        user.setCouncil("bcde");
        System.out.println(userService.SignUp(user).toString());

    }
    @Test
    public void LoginTest(){
        //User user = new User();
        user.setUsername("李四");
        user.setPassword("123456");
        System.out.println(userService.login(user).toString());

    }

    @Test
    public void UpdateDraftTest(){
        draft.setName("aaa");
        draft.setContent("abcdefg");
        System.out.println(DraftService.update(draft).toString());

    }

    @Test
    public void SearchDraftTest(){
        System.out.println(DraftService.Search(001).toString());
    }

    @Test
    public void VindicateInfoTest(){
    }


}
