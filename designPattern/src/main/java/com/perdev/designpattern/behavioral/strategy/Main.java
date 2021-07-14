package com.perdev.designpattern.behavioral.strategy;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.strategy
 * Date       2021/07/14 - 10:22
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {
        Context context1 = new Context(new Add());
        System.out.println("10+6=" + context1.execute(10, 6));

        Context context2 = new Context(new Subtract());
        System.out.println("10-6=" + context2.execute(10, 6));

        Context context3 = new Context(new Multiply());
        System.out.println("10*6=" + context3.execute(10, 6));
    }
}