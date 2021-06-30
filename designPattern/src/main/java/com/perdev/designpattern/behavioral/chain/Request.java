package com.perdev.designpattern.behavioral.chain;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.chain
 * Date       2021/06/23 - 10:59
 * Author     Payne.
 * About      类描述：
 */
public class Request {
    enum RequestType {
        TYPE_1, TYPE_2
    }

    public RequestType type;
    public String name;

    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }
}