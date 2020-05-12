package com.perdev.eventdispatch

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.RelativeLayout


/**
 * Project    demos-git
 * Path       com.perdev.demos
 * Date       2020/03/13 - 09:39
 * Author     Payne.
 * About      类描述：
 */
class MyViewGroup(context: Context, val attrs: AttributeSet, val defStyleAttr: Int = 0) :
    RelativeLayout(context, attrs, defStyleAttr) {


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        edl_d("  MyViewGroup  dispatchTouchEvent")
        //这里我们暂时先返回false
        return true
    }

}
