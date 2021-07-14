package com.perdev.designpattern.behavioral.observer;

import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.observer
 * Date       2021/07/12 - 17:02
 * Author     Payne.
 * About      类描述：
 */
public class Main {

    public static void main() {
        Subject subject = new Subject();

        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        subject.setState(14);
        subject.setState(23);


        View view=null;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        RecyclerView.Adapter adapter=null;
        adapter.notifyDataSetChanged();

    }
}