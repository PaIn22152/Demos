package com.perdev.recyclerview


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ItemDecoration
import android.view.View


/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/12/02 - 15:46
 * Author     Payne.
 * About      类描述：
 */
class LeftAndRightTagDecoration(context: Context) : ItemDecoration() {
    private val tagWidth: Int
    private val leftPaint: Paint = Paint()
    private val rightPaint: Paint

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child: View = parent.getChildAt(i)
            val pos = parent.getChildAdapterPosition(child)
            val isLeft = pos % 2 == 0
            if (isLeft) {
                val left: Float = child.left.toFloat()
                val right = left + tagWidth
                val top: Float = child.top.toFloat()
                val bottom: Float = child.bottom.toFloat()
                c.drawRect(left, top, right, bottom, leftPaint)
            } else {
                val right: Float = child.right.toFloat()
                val left = right - tagWidth
                val top: Float = child.top.toFloat()
                val bottom: Float = child.bottom.toFloat()
                c.drawRect(left, top, right, bottom, rightPaint)
            }
        }
    }


    init {
        leftPaint.color = context.resources.getColor(R.color.colorAccent)
        rightPaint = Paint()
        rightPaint.color = context.resources.getColor(R.color.colorPrimary)
        tagWidth = context.resources.getDimensionPixelSize(R.dimen.tag_width)
    }
}