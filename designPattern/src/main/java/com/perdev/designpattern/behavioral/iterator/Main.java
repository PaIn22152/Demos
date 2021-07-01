package com.perdev.designpattern.behavioral.iterator;

import android.database.Cursor;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.iterator
 * Date       2021/07/01 - 10:03
 * Author     Payne.
 * About      类描述：
 */
public class Main {

    public static void main() {
        Aggregate aggregate = new DeliveryAggregate();
        aggregate.add("1111111");
        aggregate.add("22222");
        aggregate.add("3333333");
        aggregate.add("44");

        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println("当前数据为：" + iterator.next());
        }
        System.out.println("没有更多数据了。。。");


//        Cursor cursor = null;
//        if (cursor.moveToFirst()) {
//            do {
//                cursor.getInt(0);//获取第一列数据
//                cursor.getString(1);//获取第二列数据
//            } while (cursor.moveToFirst());//移到下一行
//        }

    }
}