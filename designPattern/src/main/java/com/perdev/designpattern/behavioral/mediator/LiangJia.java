package com.perdev.designpattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.mediator
 * Date       2021/07/02 - 10:27
 * Author     Payne.
 * About      类描述：
 */
public class LiangJia implements HouseMediator {

    List<Landlord> landlordList = new ArrayList<>();
    List<Purchaser> purchaserList = new ArrayList<>();

    public void addLandlord(Landlord landlord) {
        landlordList.add(landlord);
    }

    public void addPurchaser(Purchaser purchaser) {
        purchaserList.add(purchaser);
    }

    @Override
    public void notice(Person person, String msg) {
        System.out.println("中介者收到消息，并转发给目标人群");
        if (person instanceof Landlord) {
            for (Purchaser p : purchaserList) {
                p.getNotice(msg);
            }
        } else if (person instanceof Purchaser) {
            for (Landlord l : landlordList) {
                l.getNotice(msg);
            }
        }
    }
}