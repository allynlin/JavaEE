package com.cshbxy.account.Service;

import com.cshbxy.account.Dao.Account;
import com.cshbxy.account.Dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUpdateAccount {
    public static void main(String[] args) {
        //���������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //��ȡAccountDaoʵ��
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        Account account = new Account();
        account.setId(1);
        account.setUsername("tom");
        account.setBalance(2000.00);
        //����accountDao��updateAccount����,��������Ӱ�������
        int rows = accountDao.updateAccount(account);
        if (rows > 0) {
            System.out.println("��Ӱ�������:" + rows);
        } else {
            System.out.println("����ʧ��");
        }
    }
}
