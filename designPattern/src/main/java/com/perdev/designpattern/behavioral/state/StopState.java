package com.perdev.designpattern.behavioral.state;

import androidx.annotation.NonNull;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.state
 * Date       2021/07/13 - 10:00
 * Author     Payne.
 * About      类描述：
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.state = this;
    }

    @NonNull
    @Override
    public String toString() {
        return "Stop State";
    }
}