package com.perdev.designpattern.structural.bridge;

import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ListAdapter;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.bridge
 * Date       2021/06/15 - 17:46
 * Author     Payne.
 * About      类描述：
 */
public class Main {

    public static void main() {
        RedBox redBox = new RedBox();
        redBox.drawBox();


        Window window;
        WindowManager windowManager;

        AbsListView absListView;
        ListAdapter adapter;
    }
}