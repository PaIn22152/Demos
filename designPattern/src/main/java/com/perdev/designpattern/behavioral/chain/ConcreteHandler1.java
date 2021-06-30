package com.perdev.designpattern.behavioral.chain;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.chain
 * Date       2021/06/23 - 11:04
 * Author     Payne.
 * About      类描述：
 */
public class ConcreteHandler1 extends Handler {
    public ConcreteHandler1(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.type == Request.RequestType.TYPE_1) {
            System.out.println("ConcreteHandler1 handle  name=" + request.name);
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}