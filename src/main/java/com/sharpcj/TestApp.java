package com.sharpcj;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class TestApp {
    public static void main(String[] args) {
        /*Leader leader = new Leader();
        Secretary secretary = new Secretary(leader);
        secretary.meeting();
        secretary.evaluate("Joy");*/

        /*Leader leader = new Leader();
        IWork proxy = (IWork) Proxy.newProxyInstance(Leader.class.getClassLoader(),
                new Class[]{IWork.class}, new WorkInvocationHandler(leader));
        proxy.meeting();
        proxy.evaluate("Joy");
        proxy.evaluate("James");*/

        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\temp\\code");  //保存生成的 class 文件
        Enhancer enhancer = new Enhancer(); // 通过CGLIB动态代理获取代理对象的过程
        enhancer.setSuperclass(Leader.class); // 设置enhancer对象的父类
        enhancer.setCallback(new LeaderMethodInterceptor()); // 设置enhancer的回调对象
        Leader proxy= (Leader)enhancer.create(); // 创建代理对象

        // 通过代理对象调用目标方法
        proxy.meeting();
        proxy.evaluate("Joy");
        proxy.evaluate("James");
    }
}
