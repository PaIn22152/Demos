package com.perdev.designpattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.command
 * Date       2021/06/30 - 10:51
 * Author     Payne.
 * About      类描述：
 */
public class Broker {
    private List<Order> orderList=new ArrayList<>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for(Order order:orderList){
            order.execute();
        }
        orderList.clear();
    }
}