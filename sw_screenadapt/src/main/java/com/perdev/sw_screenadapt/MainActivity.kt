package com.perdev.sw_screenadapt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * sw限定符适配
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        tv_values.text = "实际使用的sw文件是：" + resources.getString(R.string.values_name)


        tv_btn
        //当没有配置sw360适配符时，系统会向下找，使用sw350，这时候宽360dp实际使用的是sw350下的值，350dp
        //所以要适配sw360分辨率，就要生成对应的sw360dp的适配符


    }
}
