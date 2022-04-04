package com.cshbxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean2Test {
    public static void main(String[] args) {
        //加载applicationBean2.xml配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationBean2.xml");
        //获取bean对象
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
        //输出bean2
        System.out.println(bean2);
    }
}
