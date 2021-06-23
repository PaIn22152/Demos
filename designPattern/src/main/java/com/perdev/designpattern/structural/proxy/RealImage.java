package com.perdev.designpattern.structural.proxy;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.proxy
 * Date       2021/06/21 - 10:32
 * Author     Payne.
 * About      类描述：
 */
public class RealImage implements Image {

    public String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }

    private void load() {
        System.out.println("load file:" + file);
    }

    @Override
    public void display() {
        System.out.println("display image:" + file);
    }
}