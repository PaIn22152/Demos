package com.perdev.designpattern.behavioral.chain;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.chain
 * Date       2021/06/23 - 11:07
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);

        handler2.handleRequest(new Request(Request.RequestType.TYPE_1, "request 111"));
        handler2.handleRequest(new Request(Request.RequestType.TYPE_2, "request 22"));
    }
}