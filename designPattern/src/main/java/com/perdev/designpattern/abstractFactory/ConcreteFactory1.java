package com.perdev.designpattern.abstractFactory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.abstractFactory
 * Date       2021/06/04 - 16:56
 * Author     Payne.
 * About      类描述：
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