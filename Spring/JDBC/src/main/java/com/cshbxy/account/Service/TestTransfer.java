package com.cshbxy.account.Service;

import com.cshbxy.account.Dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransfer {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取AccountDao实例
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        // 调用方法
        accountDao.transfer("wangwu", "zhangsan", 100);
        // 输出结果
        System.out.println("转账成功");
    }
}
