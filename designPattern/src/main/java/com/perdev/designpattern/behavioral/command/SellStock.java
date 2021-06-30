package com.perdev.designpattern.behavioral.command;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.command
 * Date       2021/06/30 - 10:50
 * Author     Payne.
 * About      类描述：
 */
public class SellStock implements Order {

    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}