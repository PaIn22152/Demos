package com.perdev.designpattern.abstractFactory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.abstractFactory
 * Date       2021/06/04 - 16:58
 * Author     Payne.
 * About      类描述：工厂实现2
 */
public class ConcreteFactory2 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB2();
    }
}