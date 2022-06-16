package com.cshbxy.controller;

import com.cshbxy.pojo.User;
import com.cshbxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Allyn
 */
@Controller
public class UserController {
  // 注入UserService对象
  @Autowired private UserService userService;
  /*
  用户登录
   */
  @RequestMapping("/login")
  public String login(User user, HttpServletRequest request) {
    try {
      // 查看是否接收到用户名和密码
      if (user.getUsername() != null && user.getPassword() != null) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
      }
      User u = userService.login(user);
      /*
      用户账号和密码是否查询出用户信息
      是：将用户信息存入session中，并跳转到主页
      否：Request域中添加提示信息，并跳转到登录页面
       */
      if (u != null) {
        request.getSession().setAttribute("USER_SESSION", u);
        return "main";
      }
      return "login";
    } catch (Exception e) {
      e.printStackTrace();
      return "login";
    }
  }

  @RequestMapping("/toMainPage")
  public String toMainPage() {
    return "main";
  }

  @RequestMapping("/logout")
  public String logout(HttpServletRequest request) {
    try {
      HttpSession session = request.getSession();
      session.invalidate();
      //            System.out.println(session.getAttribute("USER_SESSION"));
      System.out.println("用户已退出登录");
      return "login";
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("msg", "syserror");
      return "login";
    }
  }

  @RequestMapping("/studentControl")
  public String student_list() {
    return "main";
  }

  @RequestMapping("/adStu")
  public String addStudent() {
    return "addStudent";
  }

  @RequestMapping("/upStu")
  public String upStu() {
    return "updateStudent";
  }

    @RequestMapping("/findByClass")
    public String findByClass() {
        return "findStudentsByClass";
    }
}
