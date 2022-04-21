package com.cshbxy.account.Service;

import com.cshbxy.account.Dao.Account;
import com.cshbxy.account.Dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFindAccountById {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //��ȡAccountDao
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        //���÷���
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }
}
