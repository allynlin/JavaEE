package com.cshbxy.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateStudentTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        Student student = new Student();
        student.setId(1);
        student.setUsername("����");
        student.setPassword("123456");
        student.setCourse("C����");
        int result = studentDao.updateStudent(student);
        if (result > 0) {
            System.out.println("���³ɹ�");
        } else {
            System.out.println("����ʧ��");
        }
    }
}
