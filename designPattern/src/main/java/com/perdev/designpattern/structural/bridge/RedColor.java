package com.perdev.designpattern.structural.bridge;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.bridge
 * Date       2021/06/15 - 18:26
 * Author     Payne.
 * About      类描述：
 */
public class RedColor implements Color {
    @Override
    public void draw(String box) {
        System.out.println("red "+box);
    }
}