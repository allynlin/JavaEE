package com.cshbxy.dao.impl;

import com.cshbxy.dao.UserDao;

public class UserDaoImpl implements UserDao {

    //�û���¼�ж��û����������Ƿ���ȷ
    @Override
    public boolean login(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            //�����ж��û����������ǲ���admin
            return true;
        } else {
            return false;
        }
    }
}
