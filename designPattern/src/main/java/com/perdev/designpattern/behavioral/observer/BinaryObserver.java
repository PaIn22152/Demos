package com.perdev.designpattern.behavioral.observer;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.observer
 * Date       2021/07/12 - 17:06
 * Author     Payne.
 * About      类描述：
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String:" + Integer.toBinaryString(subject.getState()));
    }
}