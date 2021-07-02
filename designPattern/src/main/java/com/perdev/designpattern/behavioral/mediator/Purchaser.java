package com.perdev.designpattern.behavioral.mediator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.mediator
 * Date       2021/07/02 - 10:21
 * Author     Payne.
 * About      类描述：
 */
public class Purchaser extends Person {

    public Purchaser(String name, HouseMediator houseMediator) {
        super(name, houseMediator);
    }

    @Override
    public void send(String msg) {
        System.out.println(name + "买房者发布消息：" + msg);
        houseMediator.notice(this, msg);
    }

    @Override
    public void getNotice(String msg) {
        System.out.println(name + "买房者收到消息：" + msg);
    }
}