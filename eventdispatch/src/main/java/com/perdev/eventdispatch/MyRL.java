package com.perdev.eventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Project    demos-git
 * Path       com.perdev.eventdispatch
 * Date       2020/03/13 - 09:58
 * Author     Payne.
 * About      类描述：
 */
public class MyRL extends RelativeLayout {
    public MyRL(Context context) {
        super(context);
    }

    public MyRL(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRL(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        ED_LKt.edl_d(" MyRL  dispatchTouchEvent ");
        return false;
    }
}
