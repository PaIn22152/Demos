package com.perdev.designpattern.creational.prototype;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.creational.prototype
 * Date       2021/06/08 - 17:16
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {
        Prototype p1 = new ConcretePrototype("name1", true);
        Prototype p2 = p1.myClone();
        System.out.println("p1==p2  =  " + (p1 == p2));

        if (p2 instanceof ConcretePrototype) {
            ConcretePrototype cp = ((ConcretePrototype) p2);
            cp.setName("new name");
            System.out.println(cp.toString());
        }



        //android
//        Intent i1 = new Intent("action");
//        Intent i2 = (Intent) i1.clone();
    }
}