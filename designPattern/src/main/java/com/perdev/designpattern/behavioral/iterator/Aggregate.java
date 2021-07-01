package com.perdev.designpattern.behavioral.iterator;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.iterator
 * Date       2021/07/01 - 10:15
 * Author     Payne.
 * About      类描述：
 */
public interface Aggregate {
    int size();//容器大小

    String get(int location);//获取指定位置的数据

    void add(String s);//添加数据到容器

    void remove(String s);//从容器中移除数据

    Iterator iterator();//返回容器的迭代器
}