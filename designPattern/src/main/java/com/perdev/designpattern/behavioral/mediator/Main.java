package com.perdev.designpattern.behavioral.mediator;

import android.app.KeyguardManager;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.mediator
 * Date       2021/07/02 - 10:17
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {

        LiangJia liangJia = new LiangJia();
        Landlord bob = new Landlord("Bob", liangJia);
        liangJia.addLandlord(bob);
        liangJia.addLandlord(new Landlord("Amy", liangJia));
        liangJia.addPurchaser(new Purchaser("Jerry", liangJia));
        Purchaser jack = new Purchaser("Jack", liangJia);
        liangJia.addPurchaser(jack);

        bob.send("深圳湾壹号，别墅出租");

        jack.send("求租一个单间");


        KeyguardManager

    }
}