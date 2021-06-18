package com.perdev.designpattern.structural.decorator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.decorator
 * Date       2021/06/17 - 10:25
 * Author     Payne.
 * About      类描述：
 */
public abstract class RoomDecorator extends Room {
    protected  Room room;

    public RoomDecorator(Room room) {
        this.room = room;
    }

    @Override
    public void fitment() {
        room.fitment();
    }
}