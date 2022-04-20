package com.cshbxy.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class findStudentByUsernameAndPasswordTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        //接受键盘中输入的用户名和密码
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到学生管理系统");
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入" + username + "密码：");
        String password = scanner.next();
        Student student = studentDao.findStudentByUsernameAndPassword(username, password);
        if (student != null) {
            System.out.println("登录成功");
            System.out.println("欢迎" + student.getUsername() + "同学,您的班级是" + student.getCourse());
        } else {
            System.out.println("登录失败");
        }
    }
}
