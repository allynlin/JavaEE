package com.cshbxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringTest {
    public static void main(String[] args) {
        // ��ʼ��spring����������applicationContext.xml����
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //ͨ��������ȡ������helloSpringʵ��
        HelloSpring helloSpring=(HelloSpring) applicationContext.getBean("helloSpring");
        //����helloSpring��sayHello����
        helloSpring.sayHello();
    }
}
