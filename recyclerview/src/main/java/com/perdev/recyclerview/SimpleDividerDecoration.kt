package com.perdev.recyclerview


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ItemDecoration
import android.view.View


/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/12/02 - 15:26
 * Author     Payne.
 * About      类描述：
 */
class SimpleDividerDecoration(context: Context) : ItemDecoration() {
    private val dividerHeight: Int
    private val dividerPaint: Paint = Paint()

    init {
        dividerPaint.color = Color.parseColor("#33aa99")
        dividerHeight = context.resources.getDimensionPixelSize(R.dimen.divider_height)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val childCount = parent.childCount
        //最后一个item不设置分割线
        if (state.itemCount != childCount) {
            outRect.bottom = dividerHeight
        }

    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount
        val left = parent.paddingLeft.toFloat()
        val right = parent.width - parent.paddingRight.toFloat()
        for (i in 0 until childCount - 1) {
            val view: View = parent.getChildAt(i)
            val top: Float = view.bottom.toFloat()
            val bottom: Float = (view.bottom + dividerHeight).toFloat()
            c.drawRect(left, top, right, bottom, dividerPaint)
        }
    }



}