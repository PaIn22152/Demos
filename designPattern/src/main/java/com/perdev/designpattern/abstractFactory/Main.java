package com.perdev.designpattern.abstractFactory;


/**
 * Project    demos-git
 * Path       com.perdev.designpattern.abstractFactory
 * Date       2021/06/04 - 16:11
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {
        AbstractFactory factory = new ConcreteFactory1();
        AbstractProductA pa = factory.createProductA();
        AbstractProductB pb = factory.createProductB();

        pa.doSomething();
        pb.doSomething();
    }
}
