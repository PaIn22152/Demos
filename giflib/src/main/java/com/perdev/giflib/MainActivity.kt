package com.perdev.giflib

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.perdev.giflib.jnipackage.GifLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.ARGB_8888
        var org1 = BitmapFactory.decodeResource(
            this.resources,
            R.mipmap.bb1, options
        )
        var out1 = Bitmap.createBitmap(
            org1.getWidth(),
            org1.getHeight(),
            Bitmap.Config.ARGB_8888
        )

        iv_am_1.setImageBitmap(org1)
        iv_am_2.setImageBitmap(out1)

        tv_click.setOnClickListener {
            GifLoader.blackWhite(org1, out1)

            iv_am_1.setImageBitmap(org1)
            iv_am_2.setImageBitmap(out1)
        }
    }
}
