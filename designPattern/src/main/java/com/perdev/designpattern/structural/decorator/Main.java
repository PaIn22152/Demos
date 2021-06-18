package com.perdev.designpattern.structural.decorator;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.decorator
 * Date       2021/06/17 - 10:22
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {
        Room room1 = new NewRoom();
        Bedroom bedroom = new Bedroom(room1);
        bedroom.fitment();

        Room room2 = new NewRoom();
        Kitchen kitchen = new Kitchen(room2);
        kitchen.fitment();


        Context context;
        Activity activity;
        ContextWrapper wrapper;

    }
}