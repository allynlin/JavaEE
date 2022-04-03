package com.cshbxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User2Test {
    public static void main(String[] args) {
        //加载applicationContext.xml配置
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-User2.xml");
        //获取bean
        User2 user2 = (User2) ac.getBean("user2");
        //输出user2的信息
        System.out.println(user2);
    }
}