package com.perdev.designpattern.creational.abstractFactory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.creational.abstractFactory
 * Date       2021/06/04 - 16:56
 * Author     Payne.
 * About      类描述：工厂实现1
 */
public class ConcreteFactory1 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}