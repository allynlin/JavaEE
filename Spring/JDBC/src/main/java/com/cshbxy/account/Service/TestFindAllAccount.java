package com.cshbxy.account.Service;

import com.cshbxy.account.Dao.Account;
import com.cshbxy.account.Dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestFindAllAccount {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        //调用方法
        List<Account> accounts = accountDao.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }
}
