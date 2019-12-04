package com.perdev.recyclerview


import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.blankj.utilcode.util.SizeUtils


/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/12/02 - 14:40
 * Author     Payne.
 * About      类描述：
 */
class SimplePaddingDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private var dividerHeight = 0

    init {
        dividerHeight = context.resources.getDimensionPixelSize(R.dimen.divider_height)
        val dimension = context.resources.getDimension(R.dimen.divider_height)
        Log.d("t692", "dividerHeight = $dividerHeight")
        Log.d("t692", "dimension = $dimension")
        val px = SizeUtils.dp2px(2f)
        Log.d("t692", "px = $px")
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val childCount = parent.childCount
        //最后一个item不设置分割线
        if (state.itemCount != childCount) {
            outRect.bottom = dividerHeight
        }
    }
}