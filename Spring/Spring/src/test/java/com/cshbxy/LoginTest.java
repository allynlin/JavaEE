package com.cshbxy;

import com.cshbxy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginTest {
    public static void main(String[] args) {
        //加载applicationContext.xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-login.xml");
        //获取配置中的UserService实例
        UserService userService = (UserService) context.getBean("userService");
        //验证登录
        boolean flag=userService.login("admin", "admin");
        if (flag) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
