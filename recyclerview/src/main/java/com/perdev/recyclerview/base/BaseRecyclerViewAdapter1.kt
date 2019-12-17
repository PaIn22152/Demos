package com.perdev.recyclerview.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview.base
 * Date       2019/12/11 - 10:14
 * Author     Payne.
 * About      类描述：
 */
abstract class BaseRecyclerViewAdapter1 : RecyclerView.Adapter<BaseViewHolder>() {

    private var mItemClickListener: OnItemClickListener? = null
    private var mItemLongClickListener: OnItemLongClickListener? = null

    override fun onBindViewHolder(viewholer: BaseViewHolder, position: Int) {
        if (mItemClickListener != null) {
            viewholer.itemView.setOnClickListener {
                mItemClickListener?.onItemClick(position)
            }
        }
        if (mItemLongClickListener != null) {
            viewholer.itemView.setOnLongClickListener {
                mItemLongClickListener?.onItemLongClick(position)!!
            }
        }
    }

    fun setItemClickListener(listener: OnItemClickListener) {
        mItemClickListener = listener
    }

    fun setItemLongClickListener(listener: OnItemLongClickListener) {
        mItemLongClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(position: Int): Boolean
    }

}

