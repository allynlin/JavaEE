package com.cshbxy.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FindStudentById {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        Student student = studentDao.findStudentById(11);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("�û�������");
        }
    }
}
