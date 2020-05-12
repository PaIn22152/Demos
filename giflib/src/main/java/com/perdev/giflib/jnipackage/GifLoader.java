package com.perdev.giflib.jnipackage;

import android.graphics.Bitmap;

/**
 * Project    demos-git
 * Path       com.perdev.giflib.jnipackage
 * Date       2020/05/12 - 14:57
 * Author     Payne.
 * About      类描述：
 */
public class GifLoader {

    static {
        System.loadLibrary("GifLibHandler");
    }

    public static native void blackWhite(Bitmap input, Bitmap output);//黑白滤镜



    // 1.加载gif，返回 giflib中的 GifFileType对象地址,之后的操作都传这个GifFileType的地址过去
    public static native long loadGif(String gifPath);

    // 2. 获取gif宽高
    public static native int getWidth(long nativeGifFile);

    public static native int getHeight(long nativeGifFile);

    // 3.更新bitmap，更新成功就回调runnable
    public static native int updateBitmap(long nativeGifFile, Bitmap bitmap, Runnable runnable);

    public static native void destroy(long nativeGifFile);

}
