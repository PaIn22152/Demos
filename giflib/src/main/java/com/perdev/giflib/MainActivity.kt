package com.perdev.giflib

import android.R.attr.bitmap
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.perdev.giflib.jnipackage.GifLoader
import kotlinx.android.synthetic.main.activity_main.*
import pl.droidsonroids.gif.GifDrawable
import java.io.File


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
        GifLoader.blackWhite(org1, out1)

        iv_am_1.setImageBitmap(org1)
        iv_am_2.setImageBitmap(out1)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val str = arrayOf(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            requestPermissions(str, 1)
        }


        tv_click.setOnClickListener {

//            loadBitmap()

            val gifDrawable = GifDrawable(resources, R.mipmap.yexiu)
//            giv_am_gif
//            gifDrawable.
        }
    }

    private fun d(s: String) {
        Log.d("gi5tw", s)
    }


    private fun loadBitmap() {

        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.ARGB_8888
        var gif = BitmapFactory.decodeResource(
            this.resources,
            R.mipmap.yexiu, options
        )
        iv_am_gif.setImageBitmap(gif)


        // /storage/emulated/0/gif/yexiu.gif
        // /storage/emulated/0/gif/giphy.webp
        val file = File(Environment.getExternalStorageDirectory(), "gif/yexiu.gif")
//        val file = File(Environment.getExternalStorageDirectory(), "gif/giphy.webp")
        d("file.exists = ${file.exists()}   path = ${file.absolutePath}")
        //1 加载gif
        val loader = GifLoader.load(file.absolutePath)
        d("1")
        //2.得到gif的宽高
        val width: Int = GifLoader.getWidth(loader.nativeGifFile)
        d("2")
        val height: Int = GifLoader.getHeight(loader.nativeGifFile)

        d(" width = $width   height = $height")
        //3.根据gif宽高创建一个Bitmap
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        d(" bitmap = ${bitmap.width}")


        // 4.处理这个Bitmap，每一帧处理完都会回调run方法
        GifLoader.updateBitmap(
            loader.nativeGifFile,
            bitmap,
            Runnable { //在子线程回调，需要切换到主线程操作UI
                runOnUiThread {
                    iv_am_gif.setImageBitmap(bitmap)
                }
            })
    }
}
