// c 代码
#include <android/bitmap.h>
#include <android/log.h>
#include <malloc.h>
//#include "giflib/gif_lib.h"

#define TAG "bitmaplibtag"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, TAG ,__VA_ARGS__)


extern "C"
JNIEXPORT void JNICALL
Java_com_perdev_giflib_jnipackage_GifLoader_blackWhite(
        JNIEnv *env, jobject obj, jobject source, jobject target
) {
    LOGE(" BitmapFilter_blackWhite  start  ");
    int result;
// 获取源Bitmap相关信息：宽、高等
    AndroidBitmapInfo sourceInfo;
    result = AndroidBitmap_getInfo(env, source, &sourceInfo);
    LOGE("res  get bitmap info  : %d", result);
    if (result < 0) {
        LOGE("get bitmap info error : %d", result);
        return;
    }
// 获取源Bitmap像素数据 这里用的是32位的int类型 argb每个8位
    uint32_t *sourceData;
    result = AndroidBitmap_lockPixels(env, source, (void **) &sourceData);
    if (result < 0) {
        LOGE("bitmap lock pixels error : %d", result);
        return;
    }
// 锁定Bitmap
// 并获取目标Bitmap像素数据
// 注意：传进来的Bitmap只是一张空的Bitmap
    uint32_t *targetData;
    result = AndroidBitmap_lockPixels(env, target, (void **) &targetData);
    if (result < 0) {
        LOGE("bitmap lock pixels error : %d", result);
        return;
    }
// 遍历各个像素点
    int color;
    int alpha = 0xff << 24;
    int red, green, blue;
    int width = sourceInfo.width;
    int height = sourceInfo.height;
    int w, h;
    for (h = 0; h < height; h++) {
        for (w = 0; w < width; w++) {
            color = sourceData[h * width + w];
            red = (color & 0x00ff0000) >> 16;
            green = (color & 0x0000ff00) >> 8;
            blue = color & 0x000000ff;
// rgb颜色相同就是黑白图片了 取平均值只是一个方案
            color = (red + green + blue) / 3;
            targetData[h * width + w] = alpha | (color << 16) | (color << 8) | color;
        }
    }
    AndroidBitmap_unlockPixels(env, source);
    AndroidBitmap_unlockPixels(env, target);
}


/*
extern "C"
JNIEXPORT jlong JNICALL
Java_com_perdev_giflib_jnipackage_GifLoader_loadGif(JNIEnv *env, jclass clazz, jstring path) {

    const char *filePath = env->GetStringUTFChars(path, 0);

    int err;
    // 1.调用源码api里方法，打开gif，返回GifFileType实体
    GifFileType *GifFile = DGifOpenFileName(filePath, &err);

//    LOGD("filePath = %s", filePath);
//    LOGD("loadGif,SWidth = %d", GifFile->SWidth);
//    LOGD("loadGif,SHeight = %d", GifFile->SHeight);
    return (long long) GifFile;
}


extern "C"
JNIEXPORT jint JNICALL
Java_com_perdev_giflib_jnipackage_GifLoader_getWidth(JNIEnv *env, jclass clazz, jlong nativeGifFile) {
    // 获取gif 宽
    GifFileType *GifFile = (GifFileType *) nativeGifFile;
    return GifFile->SWidth;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_perdev_giflib_jnipackage_GifLoader_getHeight(JNIEnv *env, jclass clazz, jlong nativeGifFile) {
    // 获取gif 高
    GifFileType *GifFile = (GifFileType *) nativeGifFile;
    return GifFile->SHeight;
}



extern "C"
JNIEXPORT void JNICALL
Java_com_perdev_giflib_jnipackage_GifLoader_destroy(JNIEnv *env, jclass clazz,
                                                   jlong native_gif_file) {
    // TODO: implement destroy()

    isDestroy = true;
}*/




