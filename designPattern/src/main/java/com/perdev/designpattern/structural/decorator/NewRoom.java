package com.perdev.designpattern.structural.decorator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.decorator
 * Date       2021/06/17 - 10:24
 * Author     Payne.
 * About      类描述：
 */
public class NewRoom extends Room {
    @Override
    public void fitment() {
        System.out.println("这是新房子，装地板，装电");
    }
}