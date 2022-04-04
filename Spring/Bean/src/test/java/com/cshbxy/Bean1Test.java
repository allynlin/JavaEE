package com.cshbxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean1Test {
    public static void main(String[] args) {
        //加载applicationBean1.xml配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationBean1.xml");
        //获取Bean1实例
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        //输出Bean1实例
        System.out.println(bean1);
    }
}
