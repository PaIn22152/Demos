package com.perdev.designpattern.behavioral.command;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.command
 * Date       2021/06/30 - 10:47
 * Author     Payne.
 * About      类描述：
 */
public class Stock {

    public String name;
    public int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy() {
        System.out.println("Stock [ Name: " + name + "," +
                " Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", " +
                "Quantity: " + quantity + " ] sold");
    }
}