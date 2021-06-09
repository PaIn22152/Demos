package com.perdev.recyclerview.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview.base
 * Date       2019/12/17 - 15:17
 * Author     Payne.
 * About      类描述：
 */
const val TYPE_HEADER_VIEW = 0x0001
const val TYPE_FOOTER_VIEW = 0x0010
const val TYPE_EMPTY_VIEW = 0x0100
const val TYPE_LOADING_VIEW = 0x1000

abstract class BaseRecyclerViewAdapter2<D, VH : BaseViewHolder>(
        val mContext: Context, @LayoutRes val mLayoutId: Int, val mData: List<D>)
    : androidx.recyclerview.widget.RecyclerView.Adapter<VH>() {

    private var mHeaderLayout: LinearLayout? = null
    private var mFooterLayout: LinearLayout? = null
    //    private var mContext: Context? = null
    private var mLayoutInflater: LayoutInflater? = null

    fun getHeaderLayoutCount(): Int {
        return if (mHeaderLayout == null || mHeaderLayout?.childCount == 0) {
            0
        } else 1
    }

    fun getFooterLayoutCount(): Int {
        return if (mFooterLayout == null || mFooterLayout?.childCount == 0) {
            0
        } else 1
    }

    override fun getItemCount(): Int {
        return getHeaderLayoutCount() + mData.size + getFooterLayoutCount()
    }

    override fun getItemViewType(position: Int): Int {
        val haveHeader = getHeaderLayoutCount() == 1
        if (haveHeader && position == 0) {
            return TYPE_HEADER_VIEW
        }
        val haveFooter = getFooterLayoutCount() == 1
        if (haveFooter && position == itemCount - 1) {
            return TYPE_FOOTER_VIEW
        }

        //todo empty and loading
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, itemType: Int): VH {
//        if (mContext == null) {
//            mContext = parent.context
//        }
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(mContext)
        }
        var vh: VH? = null
        when (itemType) {
            TYPE_HEADER_VIEW -> {
                val headerLayoutVp = mHeaderLayout!!.parent
                if (headerLayoutVp is ViewGroup) {
                    headerLayoutVp.removeView(mHeaderLayout)
                }
                vh = mHeaderLayout?.let { createBaseViewHolder(it) }
            }
            TYPE_FOOTER_VIEW -> {
                val headerLayoutVp = mFooterLayout!!.parent
                if (headerLayoutVp is ViewGroup) {
                    headerLayoutVp.removeView(mFooterLayout)
                }
                vh = mFooterLayout?.let { createBaseViewHolder(it) }
            }
            TYPE_EMPTY_VIEW -> {

            }
            TYPE_LOADING_VIEW -> {

            }
            else -> {
                vh = createBaseViewHolder(getItemView(mLayoutId, parent))
            }
        }
        return vh!!
    }


    fun createBaseViewHolder(item: View): VH {
        return BaseViewHolder(item) as VH
    }

    fun getItemView(layoutId: Int, parent: ViewGroup): View {
        return mLayoutInflater?.inflate(layoutId, parent, false)!!
    }

    override fun onBindViewHolder(viewHolder: VH, position: Int) {
        val viewType = viewHolder.itemViewType
        when (viewType) {
            TYPE_HEADER_VIEW -> {

            }
            TYPE_FOOTER_VIEW -> {

            }
            TYPE_EMPTY_VIEW -> {

            }
            TYPE_LOADING_VIEW -> {

            }
            else -> {
                val pos = position - getHeaderLayoutCount()
                convert(viewHolder, pos, getItem(pos)!!)
            }
        }
    }

    fun getItem(pos: Int): D? {
        if (pos >= 0 && pos < mData.size) {
            return mData[pos]
        }
        return null
    }

    fun addHeaderView(header: View) {
        addHeaderView(header, 0, LinearLayout.VERTICAL)
    }

    /**
     * @param header
     * @param index
     * @param orientation
     */
    open fun addHeaderView(header: View, index: Int, orientation: Int): Int {
        if (mHeaderLayout == null) {
            mHeaderLayout = LinearLayout(mContext)
            if (orientation == LinearLayout.VERTICAL) {
                mHeaderLayout!!.orientation = LinearLayout.VERTICAL
                mHeaderLayout!!.layoutParams = androidx.recyclerview.widget.RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            } else {
                mHeaderLayout!!.orientation = LinearLayout.HORIZONTAL
                mHeaderLayout!!.layoutParams = androidx.recyclerview.widget.RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
            }
        }
        val childCount = mHeaderLayout!!.childCount
        var mIndex = index
        if (index < 0 || index > childCount) {
            mIndex = childCount
        }
        mHeaderLayout!!.addView(header, mIndex)
        if (mHeaderLayout!!.childCount == 1) {
            notifyItemInserted(0)
        }
        return mIndex
    }

    abstract fun convert(holder: VH, position: Int, item: D)
}