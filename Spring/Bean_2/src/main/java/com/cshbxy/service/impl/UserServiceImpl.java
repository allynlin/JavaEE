package com.cshbxy.service.impl;

import com.cshbxy.dao.UserDao;
import com.cshbxy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;
    @Override
    public void save() {
        userDao.save();
        System.out.println("调用了UserServiceImpl的save方法");
    }
}
