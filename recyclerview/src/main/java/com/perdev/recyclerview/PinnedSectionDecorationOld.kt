package com.perdev.recyclerview


import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ItemDecoration
import android.text.TextPaint
import android.text.TextUtils
import android.view.View
import com.perdev.utilslib.d
import com.perdev.utilslib.dp2px


/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/12/02 - 16:41
 * Author     Payne.
 * About      类描述：
 */
class PinnedSectionDecorationOld(context: Context, decorationCallback: DecorationCallback) :
    ItemDecoration() {
    private val callback: DecorationCallback
    private val textPaint: TextPaint
    private val paint: Paint
    private val topGap: Int
    private val fontMetrics: Paint.FontMetrics = Paint.FontMetrics()

    interface DecorationCallback {
        fun getGroupId(position: Int): Long
        fun getGroupFirstLine(position: Int): String
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos = parent.getChildAdapterPosition(view)
        val groupId = callback.getGroupId(pos)
        if (groupId < 0) return
        if (isFirstInGroup(pos)) {
            outRect.top = topGap
        }

//        else {
//            outRect.top = 0
//        }
    }

    fun d(s:String){
        d("67gnd",s)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val itemCount = state.itemCount
        val childCount = parent.childCount
        val left = parent.paddingLeft.toFloat()
        val right = parent.width - parent.paddingRight.toFloat()
        var preGroupId: Long
        var groupId: Long = -1
        d("childCount = $childCount")
        for (i in 0 until childCount) {
            val view: View = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(view)
            preGroupId = groupId
            groupId = callback.getGroupId(position)
            if (groupId < 0 || groupId == preGroupId) continue
            val textLine = callback.getGroupFirstLine(position).toUpperCase()
            if (TextUtils.isEmpty(textLine)) continue
            val viewBottom: Int = view.bottom
            var textY = topGap.coerceAtLeast(view.top).toFloat()
            if (position + 1 < itemCount) { //下一个和当前不一样移动当前
                val nextGroupId = callback.getGroupId(position + 1)
                if (nextGroupId != groupId && viewBottom < textY) { //组内最后一个view进入了header
                    textY = viewBottom.toFloat()
                }
            }
            paint.color=paint.color+i
            d("drawRect")
            c.drawRect(left, textY - topGap, right, textY, paint)
//            c.drawText(textLine, left, textY, textPaint)
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


    companion object {
        private const val TAG = "PinnedSectionDecoration"
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

//        topGap = res.getDimensionPixelSize(R.dimen.sectioned_top)
        topGap = dp2px(50f)
    }
}