package com.perdev.designpattern.behavioral.iterator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.iterator
 * Date       2021/07/01 - 10:14
 * Author     Payne.
 * About      类描述：
 */
public interface Iterator {
    boolean hasNext();//是否存在下一条记录

    Object next();//返回当前记录，并移到下一条记录
}