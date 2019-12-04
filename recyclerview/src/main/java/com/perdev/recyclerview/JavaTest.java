package com.perdev.recyclerview;

import org.jetbrains.annotations.NotNull;

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/12/02 - 16:01
 * Author     Payne.
 * About      类描述：
 */
public class JavaTest {

    private static void test(){
        SectionDecoration.DecorationCallback callback=new SectionDecoration.DecorationCallback() {
            @Override
            public long getGroupId(int position) {
                return 0;
            }

            @NotNull
            @Override
            public String getGroupFirstLine(int position) {
                return null;
            }
        };
    }
}
