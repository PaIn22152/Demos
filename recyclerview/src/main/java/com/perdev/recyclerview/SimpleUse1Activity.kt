package com.perdev.recyclerview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.perdev.recyclerview.base.BaseViewHolder
import com.perdev.utilslib.L
import kotlinx.android.synthetic.main.activity_simple_use1.*

class SimpleUse1Activity : AppCompatActivity() {

    /**
     * RecyclerView的简单使用
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_use1)

        val data: ArrayList<UserBean> = ArrayList()
        data.addAll(UserBean.defData())

        val adapter = Simple1Adapter(this, data)
        adapter.setItemClickListener(object : OnItemClickListener {
            override fun onItemClick(obj: Any, position: Int) {
                Toast.makeText(
                        this@SimpleUse1Activity,
                        "item click p = $position",
                        Toast.LENGTH_LONG
                ).show()
            }

        })
        adapter.setItemLongClickListener(object : OnItemLongClickListener {
            override fun onItemLongClick(obj: Any, position: Int) {
                Toast.makeText(
                        this@SimpleUse1Activity,
                        "item longClick p = $position",
                        Toast.LENGTH_LONG
                ).show()
            }
        })
        rv_asu1.layoutManager = LinearLayoutManager(this)
        rv_asu1.adapter = adapter


        tv_asu1_top.setOnClickListener {
            rv_asu1.scrollToPosition(0)
        }
    }


    /**
     * 为了方便查看，把类都写在了一起，实际项目中不推荐这么做
     * */
    class Simple1Adapter(
            var mContext: Context, var mData: ArrayList<UserBean>
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        companion object {
            const val GENDER_FEMALE = 0
            const val GENDER_MALE = 1
        }

        override fun getItemViewType(position: Int): Int {
            return if (mData[position].gender) {
                GENDER_MALE
            } else {
                GENDER_FEMALE
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            L.d("66yt7", "onCreateViewHolder p = $viewType")
            return if (viewType == GENDER_FEMALE) {
                val view = LayoutInflater.from(mContext).inflate(R.layout.item_simple_1_female, null)
                MyVH1(view)
            } else {
                val view = LayoutInflater.from(mContext).inflate(R.layout.item_simple_1, null)
                MyVH1(view)
            }
        }

        override fun getItemCount(): Int {
            return mData.size
        }

        override fun onBindViewHolder(viewholer: RecyclerView.ViewHolder, position: Int) {
            L.d("66yt7", "onBindViewHolder p = $position")
            if (viewholer is MyVH1) {
                val tv_is1_name: TextView? = viewholer.getViewById(R.id.tv_is1_name)
                val strName = "姓名:" + mData[position].name
                tv_is1_name?.text = strName

                val tv_is1_age: TextView? = viewholer.getViewById(R.id.tv_is1_age)
                val strAge = "年龄:" + mData[position].age
                tv_is1_age?.text = strAge

                if (mItemClickListener != null) {
                    viewholer.itemView.setOnClickListener {
                        L.d("66yt7", "item click p = $position")
                        mItemClickListener?.onItemClick(mData[position], position)
                    }
                }
                if (mItemLongClickListener != null) {
                    viewholer.itemView.setOnLongClickListener {
                        mItemLongClickListener?.onItemLongClick(mData[position], position)
                        true
                    }
                }
            }
        }

        private var mItemClickListener: OnItemClickListener? = null
        private var mItemLongClickListener: OnItemLongClickListener? = null
        fun setItemClickListener(listener: OnItemClickListener) {
            mItemClickListener = listener
        }

        fun setItemLongClickListener(listener: OnItemLongClickListener) {
            mItemLongClickListener = listener
        }

    }

    interface OnItemClickListener {
        fun onItemClick(obj: Any, position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(obj: Any, position: Int)
    }

    class MyVH1(itemView: View) : BaseViewHolder(itemView)


    data class UserBean(val name: String, val age: Int, val gender: Boolean = true) {
        //伴生对象
        companion object {
            fun defData(): ArrayList<UserBean> {
                val res = ArrayList<UserBean>()
                res.add(UserBean("Amy", 13, false))
                res.add(UserBean("Bob", 10))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Don", 11))

                res.add(UserBean("Amy", 13, false))
                res.add(UserBean("Bob", 10))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Don", 11))
                res.add(UserBean("Amy", 13, false))
                res.add(UserBean("Bob", 10))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Don", 11))
                return res
            }
        }
    }
}
