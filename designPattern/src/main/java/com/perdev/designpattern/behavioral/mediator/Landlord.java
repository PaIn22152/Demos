package com.perdev.designpattern.behavioral.mediator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.mediator
 * Date       2021/07/02 - 10:25
 * Author     Payne.
 * About      类描述：
 */
public class Landlord extends Person {

    public Landlord(String name, HouseMediator houseMediator) {
        super(name, houseMediator);
    }

    @Override
    public void send(String msg) {
        System.out.println(name + "房东发布消息：" + msg);
        houseMediator.notice(this, msg);
    }

    @Override
    public void getNotice(String msg) {
        System.out.println(name + "房东收到消息：" + msg);
    }
}