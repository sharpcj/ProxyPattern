package com.sharpcj.proxytest;

import java.lang.reflect.Proxy;

public class TestApp {
    public static void main(String[] args) {
        IWork worker = (IWork) Proxy.newProxyInstance(IWork.class.getClassLoader(), new Class[]{IWork.class},
                new WorkInvocationHandler(new IWork() {
                    @Override
                    public IWork work(String subject) {
                        return null;
                    }
                }));
        worker.work("AAA").work("BBB").work("CCC");
    }
}
