package com.perdev.designpattern.structural.flyweight;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.flyweight
 * Date       2021/06/18 - 11:18
 * Author     Payne.
 * About      类描述：
 */
public class ShareBike implements IBike {

    final private int price;//单价

    public ShareBike(int price) {
        this.price = price;
    }

    @Override
    public void billing(int time) {
        int total = time * price;
        System.out.println("骑单车花费：" + total);
    }
}