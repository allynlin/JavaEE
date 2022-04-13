package com.cshbxy.demo2;

public class CglibTest {
    public static void main(String[] args) {
        // 创建一个Cglib代理对象
        CglibProxy cglibProxy = new CglibProxy();
        // 获取目标对象
        UserDao userDao=new UserDao();
        // 获取增强后的目标对象
        UserDao userDao1 = (UserDao) cglibProxy.createProxy(userDao);
        // 调用目标对象的方法
        userDao1.addUser();
        userDao1.deleteUser();
    }
}
