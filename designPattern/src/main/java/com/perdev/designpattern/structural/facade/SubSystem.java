package com.perdev.designpattern.structural.facade;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.facade
 * Date       2021/06/18 - 10:19
 * Author     Payne.
 * About      类描述：
 */
public class SubSystem {

    public void turnOnTV() {
        System.out.println("turn on tv!");
    }

    public void setCD(String s) {
        System.out.println("set CD:" + s);
    }

    public void startWatching() {
        System.out.println("start watching!");
    }
}