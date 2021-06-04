package com.perdev.designpattern.abstractFactory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.abstractFactory
 * Date       2021/06/04 - 16:50
 * Author     Payne.
 * About      类描述：
 */
public class ProductA1 implements AbstractProductA {
    @Override
    public void doSomething() {
        System.out.println("I'm ProductA1");
    }
}