package com.perdev.designpattern.structural.proxy;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.proxy
 * Date       2021/06/21 - 10:34
 * Author     Payne.
 * About      类描述：
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    final private String file;

    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(file);
        }
        realImage.display();
    }
}