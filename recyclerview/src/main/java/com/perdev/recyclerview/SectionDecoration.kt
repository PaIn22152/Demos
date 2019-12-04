package com.perdev.recyclerview


import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ItemDecoration
import android.text.TextPaint
import android.util.Log
import android.view.View


/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/12/02 - 15:53
 * Author     Payne.
 * About      类描述：
 */
class SectionDecoration(
    context: Context,
    decorationCallback: DecorationCallback
) :
    ItemDecoration() {
    private val callback: DecorationCallback
    private val textPaint: TextPaint
    private val paint: Paint
    private val topGap: Int
    private val fontMetrics: Paint.FontMetrics = Paint.FontMetrics()

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos = parent.getChildAdapterPosition(view)
        Log.i(TAG, "getItemOffsets：$pos")
        val groupId = callback.getGroupId(pos)
        if (groupId < 0) return
        if (pos == 0 || isFirstInGroup(pos)) { //同组的第一个才添加padding
            outRect.top = topGap
        } else {
            outRect.top = 0
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val left = parent.paddingLeft.toFloat()
        val right = parent.width - parent.paddingRight.toFloat()
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val view: View = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(view)
            val groupId = callback.getGroupId(position)
            if (groupId < 0) return
            val textLine = callback.getGroupFirstLine(position).toUpperCase()
            if (position == 0 || isFirstInGroup(position)) {
                val top: Float = (view.top - topGap).toFloat()
                val bottom: Float = view.top.toFloat()
                c.drawRect(left, top, right, bottom, paint) //绘制红色矩形
                c.drawText(textLine, left, bottom, textPaint) //绘制文本
            }
        }
    }


    private fun isFirstInGroup(pos: Int): Boolean {
        return if (pos == 0) {
            true
        } else {
            val prevGroupId = callback.getGroupId(pos - 1)
            val groupId = callback.getGroupId(pos)
            prevGroupId != groupId
        }
    }

    interface DecorationCallback {
        fun getGroupId(position: Int): Long
        fun getGroupFirstLine(position: Int): String
    }

    companion object {
        private const val TAG = "SectionDecoration"
    }

    init {
        val res: Resources = context.resources
        callback = decorationCallback
        paint = Paint()
        paint.color = res.getColor(R.color.colorAccent)
        textPaint = TextPaint()
        textPaint.typeface = Typeface.DEFAULT_BOLD
        textPaint.isAntiAlias = true
        textPaint.textSize = 80f
        textPaint.color = Color.BLACK
        textPaint.getFontMetrics(fontMetrics)
        textPaint.textAlign = Paint.Align.LEFT
        topGap = res.getDimensionPixelSize(R.dimen.sectioned_top)
    }
}