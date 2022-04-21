package com.cshbxy.student.Service;

import com.cshbxy.student.Dao.Student;
import com.cshbxy.student.Dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateStudentTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        Student student = new Student();
        student.setId(2);
        student.setUsername("test");
        student.setPassword("11111");
        student.setCourse("C++");
        int result = studentDao.updateStudent(student);
        if (result > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }
}
