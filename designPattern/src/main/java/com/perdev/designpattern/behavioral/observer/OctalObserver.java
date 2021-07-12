package com.perdev.designpattern.behavioral.observer;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.observer
 * Date       2021/07/12 - 17:08
 * Author     Payne.
 * About      类描述：
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String:" + Integer.toOctalString(subject.getState()));
    }
}