package com.perdev.designpattern.structural.flyweight;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.flyweight
 * Date       2021/06/18 - 11:15
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {
        BikeFactory factory = new BikeFactory();

        IBike bike1 = factory.getBike("ofo");
        bike1.billing(3);

        IBike bike2 = factory.getBike("mobai");
        bike2.billing(2);

        IBike bike3 = factory.getBike("ofo");
        bike3.billing(2);
    }
}