package com.cshbxy.account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDeleteAccount {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        int num = accountDao.deleteAccount(1);
        if (num > 0) {
            System.out.println("ɾ���ɹ�");
        } else {
            System.out.println("ɾ��ʧ��");
        }
    }
}
