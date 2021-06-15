package com.perdev.designpattern.structural.bridge;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.bridge
 * Date       2021/06/15 - 18:27
 * Author     Payne.
 * About      类描述：
 */
public abstract class Box {
    protected Color color;

    public Box(Color color) {
        this.color = color;
    }

    abstract void drawBox();
}