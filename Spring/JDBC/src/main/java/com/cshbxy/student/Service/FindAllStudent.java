package com.cshbxy.student.Service;

import com.cshbxy.student.Dao.Student;
import com.cshbxy.student.Dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FindAllStudent {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        List<Student> students = studentDao.findAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
