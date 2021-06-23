package com.perdev.designpattern.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.proxy
 * Date       2021/06/21 - 10:59
 * Author     Payne.
 * About      类描述：
 */
public class DynamicProxy implements InvocationHandler {

    final private Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理，调用方法之前");
        Object result = method.invoke(obj, args);//调用被代理的对象的方法
        System.out.println("动态代理，调用方法之后，result=" + result);
        return result;
    }
}