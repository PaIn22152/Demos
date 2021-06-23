package com.perdev.designpattern.structural.proxy;

import java.lang.reflect.Proxy;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.proxy
 * Date       2021/06/21 - 10:30
 * Author     Payne.
 * About      类描述：
 */
public class Main {

    public static void main() {
        ProxyImage proxyImage = new ProxyImage("namei.jpg");
        proxyImage.display();

        proxyImage.display();


        //动态代理
        RealImage realImage = new RealImage("lufei.jpg");
        DynamicProxy dynamicProxy = new DynamicProxy(realImage);
        ClassLoader classLoader = realImage.getClass().getClassLoader();
        Image image = (Image) Proxy.newProxyInstance(classLoader,
                new Class[]{Image.class}, dynamicProxy);
        image.display();
    }
}