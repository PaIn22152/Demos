package com.perdev.designpattern.structural.bridge;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.bridge
 * Date       2021/06/15 - 18:28
 * Author     Payne.
 * About      类描述：
 */
public class RedBox extends Box {
    public RedBox() {
        super(new RedColor());
    }

    @Override
    void drawBox() {
        this.color.draw("box");
    }
}