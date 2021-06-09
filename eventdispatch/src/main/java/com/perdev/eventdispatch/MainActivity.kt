package com.perdev.eventdispatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.MotionEvent
import com.perdev.utilslib.d
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rl_main.setOnClickListener {
            edl_d("click  rl_main ")
        }

        tv_click.setOnClickListener {
            edl_d("click  tv_click ")
        }

//        MotionEvent.ACTION_DOWN
//        MotionEvent.ACTION_MOVE
//        MotionEvent.ACTION_UP
//        MotionEvent.ACTION_CANCEL


    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        edl_d("MainActivity  dispatchTouchEvent ")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        edl_d("MainActivity  onTouchEvent ")
        return super.onTouchEvent(event)
    }


}
