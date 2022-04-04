package com.cshbxy.dao.impl;

import com.cshbxy.dao.UserDao;
import com.cshbxy.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=(User) ac.getBean("user",User.class);
        System.out.println(user);
        System.out.println("调用了UserDaoImpl的save方法");
    }
}
