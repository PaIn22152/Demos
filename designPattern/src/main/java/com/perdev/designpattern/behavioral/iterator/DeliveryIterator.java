package com.perdev.designpattern.behavioral.iterator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.iterator
 * Date       2021/07/01 - 10:18
 * Author     Payne.
 * About      类描述：
 */
public class DeliveryIterator implements Iterator {

    private Aggregate aggregate;//容器对象
    private int index;//当前索引

    public DeliveryIterator(Aggregate aggregate) {
        this.aggregate = aggregate;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.size();
    }

    @Override
    public Object next() {
        return aggregate.get(index++);
    }
}