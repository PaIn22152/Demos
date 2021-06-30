package com.perdev.designpattern.behavioral.command;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.command
 * Date       2021/06/30 - 10:48
 * Author     Payne.
 * About      类描述：
 */
public class BuyStock implements Order {

    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}