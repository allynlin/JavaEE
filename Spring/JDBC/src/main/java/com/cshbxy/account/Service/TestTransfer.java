package com.cshbxy.account.Service;

import com.cshbxy.account.Dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransfer {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // ��ȡAccountDaoʵ��
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        // ���÷���
        accountDao.transfer("wangwu", "zhangsan", 100);
        // ������
        System.out.println("ת�˳ɹ�");
    }
}
