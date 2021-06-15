package com.perdev.designpattern.structural.adapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.adapter
 * Date       2021/06/15 - 15:43
 * Author     Payne.
 * About      类描述：
 */
public class Main {

    public static void main() {
        Output220v output220v = new Output220v();
        Input5v1a input5v1a = new PowerAdapter(output220v);
        input5v1a.in();

//        RecyclerView view = null;
//        view.setAdapter(new MyAdapter(new ArrayList<>()));
    }
}