package com.cshbxy.service.impl;

import com.cshbxy.dao.UserDao;
import com.cshbxy.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //ÓÃ»§µÇÂ¼
    public boolean login(String username,String password){
        return userDao.login(username,password);
    }
}
