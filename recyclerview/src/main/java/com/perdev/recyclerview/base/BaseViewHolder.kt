package com.perdev.recyclerview.base

import android.support.v7.widget.RecyclerView
import android.view.View

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
}