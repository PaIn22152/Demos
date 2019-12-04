package com.perdev.recyclerview;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Project    CustomViews-git
 * Path       com.perdev.viewlib.utils
 * Date       2019/11/11 - 16:16
 * Author     Payne.
 * About      类描述：
 * 今日头条屏幕适配方案实现
 */
public class ScreenAdaptUtil {

    // 系统的Density
    private static float sNoncompatDensity;
    // 系统的ScaledDensity
    private static float sNoncompatScaledDensity;

    private static void d(String s) {
        Log.d("sa667", s);
    }

    public static void doDensity(Activity activity) {
        final Application application = activity.getApplication();
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (sNoncompatDensity == 0) {
            sNoncompatDensity = displayMetrics.density;
            sNoncompatScaledDensity = displayMetrics.scaledDensity;
            // 监听在系统设置中切换字体
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNoncompatScaledDensity = application.getResources()
                                .getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
//        float targetDensity = (float) displayMetrics.widthPixels / 300f;
//        float targetDensity = (float) displayMetrics.widthPixels / 360f;
        // 此处以400dp的设计图作为例子
        float targetDensity = (float) displayMetrics.widthPixels / 400f;
        float targetScaledDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity);
        int targetDensityDpi = (int) (160 * targetDensity);
        displayMetrics.density = targetDensity;
        displayMetrics.scaledDensity = targetScaledDensity;
        displayMetrics.densityDpi = targetDensityDpi;

        DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;

        d("");

        DisplayMetrics systemDisplayMetrics =Resources.getSystem().getDisplayMetrics();
        systemDisplayMetrics.density = targetDensity;
        systemDisplayMetrics.scaledDensity = targetScaledDensity;
        systemDisplayMetrics.densityDpi = targetDensityDpi;
    }

}
