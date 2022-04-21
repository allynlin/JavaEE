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
        student.setUsername("����");
        student.setPassword("123456");
        student.setCourse("java");
        int result = studentDao.addStudent(student);
        if (result > 0) {
            System.out.println("��ӳɹ�");
        } else {
            System.out.println("���ʧ��");
        }
    }
}
