package com.cshbxy.account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFindAccountById {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        //调用方法
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }
}
