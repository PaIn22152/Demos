package com.perdev.designpattern.creational.abstractFactory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.creational.abstractFactory
 * Date       2021/06/04 - 16:51
 * Author     Payne.
 * About      类描述：产品B实现1
 */
public class ProductB1 implements AbstractProductB {
    @Override
    public void doSomething() {
        System.out.println("I'm ProductB1");
    }
}