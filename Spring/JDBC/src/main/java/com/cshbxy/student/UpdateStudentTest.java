package com.cshbxy.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateStudentTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        Student student = new Student();
        student.setId(1);
        student.setUsername("张三");
        student.setPassword("123456");
        student.setCourse("C语言");
        int result = studentDao.updateStudent(student);
        if (result > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }
}
