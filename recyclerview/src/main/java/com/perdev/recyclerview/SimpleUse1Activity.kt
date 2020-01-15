package com.perdev.recyclerview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perdev.recyclerview.base.BaseRecyclerViewAdapter1
import com.perdev.recyclerview.base.BaseViewHolder
import com.perdev.utilslib.d

import kotlinx.android.synthetic.main.activity_simple_use1.*

class SimpleUse1Activity : AppCompatActivity() {

    /**
     * RecyclerView的简单使用
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_use1)

        val data: ArrayList<UserBean> = ArrayList()
        data.addAll(defData())

        val adapter = Simple1Adapter1(this, data)
        adapter.setItemClickListener(object : BaseRecyclerViewAdapter1.OnItemClickListener {
            override fun onItemClick(position: Int) {
                d("66yt7", "item click p = $position")
            }
        })
        adapter.setItemLongClickListener(object : BaseRecyclerViewAdapter1.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                d("66yt7", "item longClick p = $position")
                return true
            }
        })
        rv_asu1.adapter = adapter


//        rv_asu1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val gridLayoutManager = GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                //当itemType为GENDER_FEMALE时，一个item占用三个位置
                if (adapter.getItemViewType(position) == Simple1Adapter1.GENDER_FEMALE) {
                    return gridLayoutManager.spanCount
                }
                return 1
            }
        }
        rv_asu1.layoutManager = gridLayoutManager

        rv_asu1.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)


    }

    companion object {
        fun d(s: String) {
            d("su1aTag", s)
        }
    }


    /**
     * 为了方便查看，把类都写在了一起，实际项目中不推荐这么做
     * */
    class Simple1Adapter1(
            var mContext: Context, var mData: ArrayList<UserBean>
    ) : BaseRecyclerViewAdapter1() {

        companion object {
            const val GENDER_FEMALE = 0
            const val GENDER_MALE = 1
        }

        override fun getItemViewType(position: Int): Int {
            d(" getItemViewType ")
            return if (mData[position].gender) {
                GENDER_MALE
            } else {
                GENDER_FEMALE
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
            d(" onCreateViewHolder ")
            return if (viewType == GENDER_FEMALE) {
                val view = LayoutInflater.from(mContext).inflate(R.layout.item_simple_1_female, null)
                MyVH1Female(view)
            } else {
                val view = LayoutInflater.from(mContext).inflate(R.layout.item_simple_1, null)
                MyVH1(view)
            }
        }

        override fun getItemCount(): Int {
            d(" getItemCount ")
            return mData.size
        }


        override fun onBindViewHolder(viewholer: BaseViewHolder, position: Int) {
            d(" onBindViewHolder ")
            super.onBindViewHolder(viewholer, position)
            if (viewholer is MyVH1 || viewholer is MyVH1Female) {
                val strName = "姓名:" + mData[position].name
                viewholer.setTextViewText(R.id.tv_is1_name, strName)

                val strAge = "年龄:" + mData[position].age
                viewholer.setTextViewText(R.id.tv_is1_age, strAge)
            }
            if (viewholer is MyVH1) {
                viewholer.setViewClickListener(R.id.tv_is1_test,
                        View.OnClickListener { v ->
                            d("66yt7", " click test p = $position  ; view = $v")
                        })
            }
        }


    }


    class MyVH1(itemView: View) : BaseViewHolder(itemView)
    class MyVH1Female(itemView: View) : BaseViewHolder(itemView)


    data class UserBean(val name: String, val age: Int, val gender: Boolean = true)

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
