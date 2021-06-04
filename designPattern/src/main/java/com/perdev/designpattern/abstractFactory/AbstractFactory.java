package com.perdev.designpattern.abstractFactory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.abstractFactory
 * Date       2021/06/04 - 16:53
 * Author     Payne.
 * About      类描述：
 */
public abstract class AbstractFactory {
    abstract AbstractProductA createProductA();
    abstract AbstractProductB createProductB();
}