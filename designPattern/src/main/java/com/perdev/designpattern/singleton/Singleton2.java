package com.perdev.designpattern.singleton;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.singleton.java
 * Date       2021/06/03 - 11:16
 * Author     Payne.
 * About      类描述：
 * 枚举实现单例模式，可以防止反射破坏单例
 */
public enum Singleton2 {
    INSTANCE("def");

    final private Object params;

    Singleton2(Object params) {
        this.params = params;
    }

    public void doSomething() {
        System.out.println(params);
    }
}
