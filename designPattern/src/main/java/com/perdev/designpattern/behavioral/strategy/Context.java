package com.perdev.designpattern.behavioral.strategy;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.strategy
 * Date       2021/07/14 - 10:21
 * Author     Payne.
 * About      类描述：
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int n1, int n2) {
        return strategy.doOperation(n1, n2);
    }
}