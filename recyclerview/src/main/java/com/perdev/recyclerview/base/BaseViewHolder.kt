package com.perdev.recyclerview.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview.base
 * Date       2019/12/06 - 11:38
 * Author     Payne.
 * About      类描述：
 */
open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun <T : View> findViewById(id: Int): T? {
        return itemView.findViewById(id)
    }

    fun setTextViewText(id: Int, text: String) {
        val textView = findViewById<TextView>(id)
        //通过getViewById获得view后，判空，防止空指针导致崩溃
        if (textView != null) {
            textView.text = text
        }
    }

    fun setViewClickListener(id: Int, listener: View.OnClickListener) {
        val view = findViewById<View>(id)
        view?.setOnClickListener { v -> listener.onClick(v) }
    }

    fun setViewVisibility(id: Int, visibility: Boolean) {
        val view = findViewById<View>(id)
        view?.visibility = if (visibility) View.VISIBLE else View.GONE
    }

    // todo 可以扩展其他类似的方法

}

