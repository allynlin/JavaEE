package com.cshbxy;

import com.cshbxy.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController=ac.getBean("userController",UserController.class);
        userController.save();
    }
}
