package com.perdev.jrtt_screenadapt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * 今日头条适配
     * */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        ScreenAdaptUtil.doDensity(this@MainActivity)


        setContentView(R.layout.activity_main)


        //ScreenAdaptUtil里面的方法,改变 densityDpi  density  scaledDensity 的值
        //在xml中直接使用dp作为单位，就会以ScreenAdaptUtil中的标准（400dp）适配
        val metrices = resources.displayMetrics
        val dpi = metrices.densityDpi.toString()
        val density = metrices.density.toString()
        val width = metrices.widthPixels.toString()
        val height = metrices.heightPixels.toString()
        val scaledDensity = metrices.scaledDensity.toString()

        val config = resources.configuration
        val smallestScreenWidth = config.smallestScreenWidthDp.toString()
        val msg = "dpi = " + dpi + " ;  \r\n" +
                "density = " + density + " ;  \r\n" +
                "scaledDensity = " + scaledDensity + " ;  \r\n" +
                "width = " + width + " ;  \r\n" +
                "height = " + height + " ;  \r\n" +
                "smallestScreenWidth = " + smallestScreenWidth
        tv_msg.text = msg

        //ScreenAdaptUtil中以400dp作为设计图，设置宽400dp时和屏幕等宽
        tv_btn
    }
}
