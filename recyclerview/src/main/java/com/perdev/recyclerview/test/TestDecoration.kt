package com.perdev.recyclerview.test

import android.graphics.Canvas
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview.test
 * Date       2020/01/08 - 09:43
 * Author     Payne.
 * About      类描述：
 */
class TestDecoration :RecyclerView.ItemDecoration(){

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        //
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        //
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        //
    }

}