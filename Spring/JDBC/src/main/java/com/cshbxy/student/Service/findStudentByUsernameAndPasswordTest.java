package com.cshbxy.student.Service;

import com.cshbxy.student.Dao.Student;
import com.cshbxy.student.Dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class findStudentByUsernameAndPasswordTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        //���ܼ�����������û���������
        Scanner scanner = new Scanner(System.in);
        System.out.println("��ӭ����ѧ������ϵͳ");
        System.out.println("�������û�����");
        String username = scanner.next();
        System.out.println("������" + username + "���룺");
        String password = scanner.next();
        Student student = studentDao.findStudentByUsernameAndPassword(username, password);
        if (student != null) {
            System.out.println("��¼�ɹ�");
            System.out.println("��ӭ" + student.getUsername() + "ͬѧ,���İ༶��" + student.getCourse());
        } else {
            System.out.println("��¼ʧ��");
        }
    }
}
