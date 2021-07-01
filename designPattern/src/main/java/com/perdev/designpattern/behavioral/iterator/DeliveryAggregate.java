package com.perdev.designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.iterator
 * Date       2021/07/01 - 10:22
 * Author     Payne.
 * About      类描述：
 */
public class DeliveryAggregate implements Aggregate {

    private List<String> list = new ArrayList<>();//内部使用list存储数据

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String get(int location) {
        return list.get(location);
    }

    @Override
    public void add(String s) {
        list.add(s);
    }

    @Override
    public void remove(String s) {
        list.remove(s);
    }

    @Override
    public Iterator iterator() {
        return new DeliveryIterator(this);
    }
}