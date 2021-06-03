package com.perdev.designpattern.singleton;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.singleton
 * Date       2021/06/03 - 11:01
 * Author     Payne.
 * About      类描述：双重校验锁实现单例模式
 */
public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance(Object obj) {
        Singleton tem = instance;
        if (tem == null) {
            synchronized (Singleton.class) {
                if (tem == null) {
                    instance = tem = new Singleton(obj);
                }
            }
        }
        return tem;
    }

    final private Object params;

    private Singleton(Object params) {
        this.params = params;
    }

    public void doSomething() {
        System.out.println(params);
    }
}
