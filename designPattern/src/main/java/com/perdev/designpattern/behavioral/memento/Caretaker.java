package com.perdev.designpattern.behavioral.memento;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.memento
 * Date       2021/07/12 - 11:59
 * Author     Payne.
 * About      类描述：
 */
public class Caretaker {
    private Memento memento;

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}