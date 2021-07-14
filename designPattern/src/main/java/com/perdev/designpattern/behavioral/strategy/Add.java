package com.perdev.designpattern.behavioral.strategy;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.strategy
 * Date       2021/07/14 - 10:19
 * Author     Payne.
 * About      类描述：
 */
public class Add implements Strategy {
    @Override
    public int doOperation(int n1, int n2) {
        return n1 + n2;
    }
}