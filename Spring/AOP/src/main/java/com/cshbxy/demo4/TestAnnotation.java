package com.cshbxy.demo4;

import com.cshbxy.demo3.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-Anno.xml");
        UserDao userDao=context.getBean("userDao",UserDao.class);
        userDao.delete();
        System.out.println("删除成功");
        userDao.insert();
        System.out.println("插入成功");
        userDao.select();
        System.out.println("查询成功");
        userDao.update();
        System.out.println("更新成功");
    }
}
