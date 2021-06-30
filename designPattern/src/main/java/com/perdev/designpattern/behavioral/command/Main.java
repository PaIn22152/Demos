package com.perdev.designpattern.behavioral.command;

import android.os.Looper;

import com.perdev.designpattern.behavioral.chain.Handler;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.command
 * Date       2021/06/30 - 10:45
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {

        Stock stock = new Stock("huawei", 100);

        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }
        ).start();


        android.os.Handler handler=new android.os.Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}