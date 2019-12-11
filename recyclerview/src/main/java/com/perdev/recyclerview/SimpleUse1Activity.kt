package com.perdev.recyclerview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.perdev.recyclerview.base.BaseRecyclerViewAdapter
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
        adapter.setItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                L.d("66yt7", "item click p = $position")
            }

        })
        adapter.setItemLongClickListener(object : BaseRecyclerViewAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                L.d("66yt7", "item longClick p = $position")
                return true
            }
        })
        rv_asu1.adapter = adapter

//        rv_asu1.layoutManager = LinearLayoutManager(this)
        val gridLayoutManager = GridLayoutManager(this, 3)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                //当itemType为GENDER_FEMALE时，一个item占用三个位置
                if (adapter.getItemViewType(position) == Simple1Adapter.GENDER_FEMALE) {
                    return gridLayoutManager.spanCount
                }
                return 1
            }
        }
        rv_asu1.layoutManager = gridLayoutManager


    }


    /**
     * 为了方便查看，把类都写在了一起，实际项目中不推荐这么做
     * */
    class Simple1Adapter(
            var mContext: Context, var mData: ArrayList<UserBean>
    ) : BaseRecyclerViewAdapter() {

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

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
            return if (viewType == GENDER_FEMALE) {
                val view = LayoutInflater.from(mContext).inflate(R.layout.item_simple_1_female, null)
                MyVH1Female(view)
            } else {
                val view = LayoutInflater.from(mContext).inflate(R.layout.item_simple_1, null)
                MyVH1(view)
            }
        }

        override fun getItemCount(): Int {
            return mData.size
        }


        override fun onBindViewHolder(viewholer: BaseViewHolder, position: Int) {
            super.onBindViewHolder(viewholer, position)
            if (viewholer is MyVH1 || viewholer is MyVH1Female) {
                val strName = "姓名:" + mData[position].name
                viewholer.setTextViewText(R.id.tv_is1_name, strName)

                val strAge = "年龄:" + mData[position].age
                viewholer.setTextViewText(R.id.tv_is1_age, strAge)
            }
            if (viewholer is MyVH1) {
                viewholer.getViewById<TextView>(R.id.tv_is1_test)!!.setOnClickListener {
                    L.d("66yt7", " click test p = $position")
                }
            }
        }


    }


    class MyVH1(itemView: View) : BaseViewHolder(itemView)
    class MyVH1Female(itemView: View) : BaseViewHolder(itemView)


    data class UserBean(val name: String, val age: Int, val gender: Boolean = true) {
        //伴生对象
        companion object {
            fun defData(): ArrayList<UserBean> {
                val res = ArrayList<UserBean>()
                res.add(UserBean("Amy", 13, false))
                res.add(UserBean("Bob", 10))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Don", 11))


                res.add(UserBean("Bob", 10))
                res.add(UserBean("Bob", 10))
                res.add(UserBean("Bob", 10))
                res.add(UserBean("Bob", 10))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Don", 11))
                res.add(UserBean("Amy", 13, false))
                res.add(UserBean("Bob", 10))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Don", 11))
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
