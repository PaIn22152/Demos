package com.perdev.recyclerview;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/12/02 - 16:01
 * Author     Payne.
 * About      类描述：
 */
public class JavaTest {

    private static void test() {
        SectionDecoration.DecorationCallback callback = new SectionDecoration.DecorationCallback() {
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            if (res == 0) {
                res = head.val;
            } else {
                res = res * 2 + head.val;
            }

            head = head.next;
        }
        return res;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int tem;
        for (int left = 1; left < 9; left++) {
            tem = left;
            for (int right = left + 1; right <= 9; right++) {
                tem = tem * 10 + right;
                if (tem >= low && tem <= high) {
                    res.add(tem);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    private static String g() {

        return "";
    }
}
