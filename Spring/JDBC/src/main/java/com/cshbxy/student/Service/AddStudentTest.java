package com.cshbxy.student.Service;

import com.cshbxy.student.Dao.Student;
import com.cshbxy.student.Dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddStudentTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        Student student = new Student();
        student.setUsername("张三");
        student.setPassword("123456");
        student.setCourse("java");
        int result = studentDao.addStudent(student);
        if (result > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
}
