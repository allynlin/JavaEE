package com.cshbxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User2Test {
    public static void main(String[] args) {
        //����applicationContext.xml����
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-User2.xml");
        //��ȡbean
        User2 user2 = (User2) ac.getBean("user2");
        //���user2����Ϣ
        System.out.println(user2);
    }
}