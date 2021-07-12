package com.perdev.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.observer
 * Date       2021/07/12 - 17:03
 * Author     Payne.
 * About      类描述：
 */
public class Subject {
    final private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int i) {
        state = i;
        notifyAllObserver();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}