package com.perdev.designpattern.behavioral.mediator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.mediator
 * Date       2021/07/02 - 10:19
 * Author     Payne.
 * About      类描述：
 */
public abstract class Person {

    String name;
    HouseMediator houseMediator;

    public Person(String name, HouseMediator houseMediator) {
        this.name = name;
        this.houseMediator = houseMediator;
    }

    public abstract void send(String msg);//发布消息

    public abstract void getNotice(String msg);//接收消息
}