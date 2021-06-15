package com.perdev.designpattern.creational.abstractFactory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.creational.abstractFactory
 * Date       2021/06/04 - 16:50
 * Author     Payne.
 * About      类描述：产品A实现1
 */
public class ProductA1 implements AbstractProductA {
    @Override
    public void doSomething() {
        System.out.println("I'm ProductA1");
    }
}