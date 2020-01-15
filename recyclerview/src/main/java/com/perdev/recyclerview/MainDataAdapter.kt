package com.perdev.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/11/29 - 17:36
 * Author     Payne.
 * About      类描述：
 */
class MainDataAdapter(
    var mContext: Context,
    var mData: ArrayList<DataBean>
) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.item_main_data, parent, false)
        return MyVH(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        if (viewHolder is MyVH) {
            viewHolder.setTitle(mData[i].title)
            viewHolder.setAuthor(mData[i].author)
        }
    }

    class MyVH(itemView: View) : ViewHolder(itemView) {
        private val titleTV: TextView = itemView.findViewById(R.id.tv_imd_title)
        private val authorTV: TextView = itemView.findViewById(R.id.tv_imd_author)
        fun setTitle(title: String?) {
            titleTV.text = title
        }

        fun setAuthor(title: String?) {
            authorTV.text = title
        }

    }

}


