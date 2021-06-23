package com.perdev.designpattern.structural.flyweight;

import android.os.Message;

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


//        String s1 = "abc";
//        String s2 = "abc";
//        System.out.println("s1==s2 : " + (s1 == s2));//true
//
//        Message.obtain();
    }
}