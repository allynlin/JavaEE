package com.cshbxy.account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestFindAllAccount {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //��ȡAccountDao
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        //���÷���
        List<Account> accounts = accountDao.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }
}
