package com.perdev.designpattern.behavioral.template;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.template
 * Date       2021/07/14 - 10:36
 * Author     Payne.
 * About      类描述：
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //do something
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //do something
    }
}