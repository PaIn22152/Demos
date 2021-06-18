package com.perdev.designpattern.structural.flyweight;

import java.util.HashMap;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.flyweight
 * Date       2021/06/18 - 11:19
 * Author     Payne.
 * About      类描述：
 */
public class BikeFactory {
    final private HashMap<String, IBike> pool = new HashMap<>();

    public IBike getBike(String name) {
        IBike bike;
        if (pool.containsKey(name)) {
            System.out.println("押金已交，直接用车：" + name);
            bike = pool.get(name);
        } else {
            System.out.println(name + "  第一次使用，交押金100元");
            bike = new ShareBike(2);
            pool.put(name, bike);
        }
        return bike;
    }
}