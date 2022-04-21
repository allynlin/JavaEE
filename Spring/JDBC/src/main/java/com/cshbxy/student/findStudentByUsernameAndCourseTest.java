package com.cshbxy.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class findStudentByUsernameAndCourseTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        List<Student> students = studentDao.findStudentByUsernameAndCourse("��", "c");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
