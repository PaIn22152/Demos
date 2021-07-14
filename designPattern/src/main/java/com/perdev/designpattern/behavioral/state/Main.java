package com.perdev.designpattern.behavioral.state;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.state
 * Date       2021/07/13 - 09:52
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println("" + context.state.toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println("" + context.state.toString());
    }
}