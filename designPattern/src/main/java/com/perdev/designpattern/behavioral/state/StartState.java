package com.perdev.designpattern.behavioral.state;

import androidx.annotation.NonNull;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.state
 * Date       2021/07/13 - 09:58
 * Author     Payne.
 * About      类描述：
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("player is in start state");
        context.state = this;
    }

    @NonNull
    @Override
    public String toString() {
        return "Start State";
    }
}