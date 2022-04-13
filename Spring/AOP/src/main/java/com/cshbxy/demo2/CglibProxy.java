package com.cshbxy.demo2;

import com.cshbxy.demo1.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    // 代理方法
    public Object createProxy(Object target) {
        // 创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类
        return enhancer.create();
    }
    /**
     * proxy CGlib代理类
     * method 方法
     * args 参数
     * methodProxy 方法代理
     */
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 创建切面对象
        MyAspect myAspect = new MyAspect();
        // 前增强
        myAspect.check_Permission();
        //目标方法执行
        Object obj = methodProxy.invokeSuper(proxy, args);
        // 后增强
        myAspect.log();
        return obj;
    }
}
