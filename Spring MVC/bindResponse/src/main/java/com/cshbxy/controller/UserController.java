package com.cshbxy.controller;

import com.cshbxy.pojo.User;
import com.cshbxy.pojo.UserDao;
import com.cshbxy.pojo.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserController {
    @RequestMapping("/registerUser")
    public String registerUser(User user,HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        request.setAttribute("user", user);
//        System.out.println("username:" + username + " password:" + password);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
        UserDao userDao = context.getBean(UserDao.class);
        User user1=new User();
        user1.setUsername(username);
        user1.setPassword(password);
        int result = userDao.addUser(user1);
        if (result > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        return "user/registerOK";
    }

    @RequestMapping("/loginUser")
    public String loginUser(User user, HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        request.setAttribute("user", user);
        /*User user1=new UserDaoImpl().findUserByUserNameAndPassword(username, password);*/
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
        UserDao bean = context.getBean(UserDao.class);
        User user1=bean.findUserByUserNameAndPassword(username, password);
        // 如果登录成功就跳转到user下的success，如果登录失败就跳转到user下的fail
//
        if (user1 != null) {
            return "user/success";
        }else {
            return "user/fail";
        }
    }

//    @RequestMapping("/findOrderwithUser")
//    public void findOrderWithUser(User user){
//        String username = user.getUsername();
//        String OrderId = user.getOrder().getOrderId();
//        System.out.println("username:" + username + " OrderId:" + OrderId);
//    }
}
