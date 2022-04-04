package com.cshbxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationBean1.xml");
        Bean1 bean1_1=applicationContext.getBean("bean1",Bean1.class);
        Bean1 bean1_2=applicationContext.getBean("bean1",Bean1.class);
        System.out.println(bean1_1==bean1_2);
    }
}
