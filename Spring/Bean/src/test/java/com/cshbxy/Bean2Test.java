package com.cshbxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean2Test {
    public static void main(String[] args) {
        //����applicationBean2.xml�����ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationBean2.xml");
        //��ȡbean����
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
        //���bean2
        System.out.println(bean2);
    }
}
