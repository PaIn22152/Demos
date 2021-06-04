package com.perdev.designpattern.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.test
 * Date       2021/06/04 - 15:14
 * Author     Payne.
 * About      类描述：
 */
class TestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=new Intent(this,TestActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        this.getSystemService(Context.WINDOW_SERVICE);
    }
}
