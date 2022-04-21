package com.cshbxy.student.Service;

import com.cshbxy.student.Dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteStudentTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        int result = studentDao.deleteStudent(5);
        if (result > 0) {
            System.out.println("É¾³ý³É¹¦");
        } else {
            System.out.println("É¾³ýÊ§°Ü");
        }
    }
}
