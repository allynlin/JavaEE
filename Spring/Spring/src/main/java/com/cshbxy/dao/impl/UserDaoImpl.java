package com.cshbxy.dao.impl;

import com.cshbxy.dao.UserDao;

public class UserDaoImpl implements UserDao {

    //用户登录判断用户名和密码是否正确
    @Override
    public boolean login(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            //用于判断用户名和密码是不是admin
            return true;
        } else {
            return false;
        }
    }
}
