package com.perdev.designpattern.creational.singleton;

import java.lang.reflect.Constructor;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.creational.singleton
 * Date       2021/06/03 - 11:01
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    private static void d(String s) {
        System.out.println("log_d  :  " + s);
    }

    public static void main() {
        Singleton.getInstance("name11111").doSomething();

        try {
            //反射破坏单例模式
            Class clz = Class.forName("com.perdev.designpattern.creational.singleton.Singleton");
            Constructor<Singleton> constructor = clz.getDeclaredConstructor(Object.class);
            //Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor(Object.class);

            constructor.setAccessible(true);
            Singleton singleton = constructor.newInstance("reflect");
            singleton.doSomething();

        } catch (Exception e) {
            d("e=" + e.toString());
        }


        Singleton2.INSTANCE.doSomething();
        try {
            //枚举类，不能使用反射破坏单例模式
            Class clz = Class.forName("com.perdev.designpattern.creational.singleton.Singleton2");
            d("1");
            Constructor<Singleton2> constructor = clz.getDeclaredConstructor(Object.class);
            //e=java.lang.NoSuchMethodException: com.perdev.designpattern.creational.singleton.Singleton2.<init>(java.lang.Object)
//            Constructor<Singleton2> constructor = Singleton2.class.getDeclaredConstructor(Object.class);
            d("2");
            constructor.setAccessible(true);
            Singleton2 singleton = constructor.newInstance("reflect");
            singleton.doSomething();

        } catch (Exception e) {
            d("e=" + e.toString());
        }


    }
}
