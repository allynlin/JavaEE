package com.cshbxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {
    //声明目标类接口
    private UserDao userDao;
    //创建代理方法
    public Object createProxy(UserDao userDao){
        this.userDao = userDao;
        //1.类加载器
        ClassLoader classLoader = MyProxy.class.getClassLoader();
        //2.被代理对象实现的所有接口
        Class[] interfaces=userDao.getClass().getInterfaces();
        //3.使用代理类进行增强，返回的是代理对象
        return Proxy.newProxyInstance(classLoader,interfaces,this);
    }
    /**
     * 所有动态代理类的方法调用，都会交由invoke()方法处理
     * proxy 被代理的对象
     * method 被调用的方法
     * args 调用方法时传入的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 创建切面对象
        MyAspect myAspect = new MyAspect();
        // 前增强
        myAspect.check_Permission();
        // 在目标类上调用方法，并传入参数
        Object obj = method.invoke(userDao, args);
        // 后增强
        myAspect.log();
        return obj;
    }
}
