package com.perdev.designpattern.creational.abstractFactory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.creational.abstractFactory
 * Date       2021/06/04 - 16:53
 * Author     Payne.
 * About      类描述：抽象工厂
 */
public abstract class AbstractFactory {
    abstract AbstractProductA createProductA();
    abstract AbstractProductB createProductB();
}