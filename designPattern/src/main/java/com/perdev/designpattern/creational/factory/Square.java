package com.perdev.designpattern.creational.factory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.creational.factory
 * Date       2021/06/03 - 16:36
 * Author     Payne.
 * About      类描述：
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw a square.");
    }
}
