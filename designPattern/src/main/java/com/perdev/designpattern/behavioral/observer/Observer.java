package com.perdev.designpattern.behavioral.observer;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.observer
 * Date       2021/07/12 - 17:02
 * Author     Payne.
 * About      类描述：
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}