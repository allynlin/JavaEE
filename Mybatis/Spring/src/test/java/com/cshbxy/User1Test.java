package com.cshbxy;

import org.springframework.context.ApplicationContext;

public class User1Test {
    public static void main(String[] args) {
        //����applicationContext.xml����
        ApplicationContext context = new org.springframework.context.support.ClassPathXmlApplicationContext("applicationContext-User1.xml");
        //��ȡ������User1����
        User1 user1 = (User1) context.getBean("user1",User1.class);
        //���User1����
        System.out.println(user1);
    }
}
