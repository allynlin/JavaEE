package com.cshbxy.account.Service;

import com.cshbxy.account.Dao.Account;
import com.cshbxy.account.Dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAddAccount {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        Account account = new Account();
        account.setUsername("����");
        account.setBalance(1000.00);
        //ִ��addAccount����,�����ؽ��
        int num = accountDao.addAccount(account);
        if (num > 0) {
            System.out.println("�ɹ�������" + num + "����¼");
        } else {
            System.out.println("����ʧ��");
        }
    }
}
