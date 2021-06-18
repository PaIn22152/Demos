package com.perdev.designpattern.structural.decorator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.decorator
 * Date       2021/06/17 - 10:27
 * Author     Payne.
 * About      类描述：
 */
public class Bedroom extends RoomDecorator {
    public Bedroom(Room room) {
        super(room);
    }

    @Override
    public void fitment() {
        super.fitment();
        System.out.println("装修成卧室，添加卧具");
    }
}