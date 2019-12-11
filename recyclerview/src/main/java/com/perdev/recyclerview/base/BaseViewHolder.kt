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
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun <T : View> getViewById(id: Int): T? {
        return itemView.findViewById(id)
    }

    //可以扩展其他类似的方法
    fun setTextViewText(id: Int, text: String) {
        getViewById<TextView>(id)!!.text = text
    }
}