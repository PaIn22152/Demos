package com.perdev.designpattern.behavioral.chain;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.chain
 * Date       2021/06/23 - 11:01
 * Author     Payne.
 * About      类描述：
 */
public abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handleRequest(Request request);
}