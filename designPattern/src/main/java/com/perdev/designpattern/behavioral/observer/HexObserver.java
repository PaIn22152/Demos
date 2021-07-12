package com.perdev.designpattern.behavioral.observer;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.observer
 * Date       2021/07/12 - 17:09
 * Author     Payne.
 * About      类描述：
 */
public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String:" + Integer.toHexString(subject.getState()));
    }
}