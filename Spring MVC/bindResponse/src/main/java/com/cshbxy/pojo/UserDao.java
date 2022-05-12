package com.cshbxy.pojo;

public interface UserDao {
    public User findUserByUserNameAndPassword(String username, String password);

    // 添加用户
    public int addUser(User user);
}
