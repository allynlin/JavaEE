package com.cshbxy.student.Service;

import com.cshbxy.student.Dao.Student;
import com.cshbxy.student.Dao.StudentDao;
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
            System.out.println("用户不存在");
        }
    }
}
