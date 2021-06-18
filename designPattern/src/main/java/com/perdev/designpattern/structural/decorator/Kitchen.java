package com.perdev.designpattern.structural.decorator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.decorator
 * Date       2021/06/17 - 10:29
 * Author     Payne.
 * About      类描述：
 */
public class Kitchen extends RoomDecorator {
    public Kitchen(Room room) {
        super(room);
    }

    @Override
    public void fitment() {
        super.fitment();
        System.out.println("装修成厨房，添加厨房用品");
    }
}