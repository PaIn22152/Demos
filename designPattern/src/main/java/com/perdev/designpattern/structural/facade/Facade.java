package com.perdev.designpattern.structural.facade;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.facade
 * Date       2021/06/18 - 10:21
 * Author     Payne.
 * About      类描述：
 */
public class Facade {
    SubSystem subSystem = new SubSystem();

    public void watchMovie(String s) {
        subSystem.turnOnTV();
        subSystem.setCD(s);
        subSystem.startWatching();
    }
}