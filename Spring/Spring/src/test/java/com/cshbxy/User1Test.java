package com.cshbxy;

import org.springframework.context.ApplicationContext;

public class User1Test {
    public static void main(String[] args) {
        //加载applicationContext.xml配置
        ApplicationContext context = new org.springframework.context.support.ClassPathXmlApplicationContext("applicationContext-User1.xml");
        //获取配置中User1对象
        User1 user1 = (User1) context.getBean("user1",User1.class);
        //输出User1对象
        System.out.println(user1);
    }
}
