package com.perdev.recyclerview

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import com.perdev.recyclerview.base.BaseRecyclerViewAdapter2
import com.perdev.recyclerview.base.BaseViewHolder
import kotlinx.android.synthetic.main.activity_header_footer.*

class HeaderFooterActivity : AppCompatActivity() {

    /**
     * 使用itemView的type，实现headerView，footerView，emptyView，loadingView
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_header_footer)


        val mData: ArrayList<UserBean> = ArrayList()
        mData.addAll(UserBean.defData())

        val adapter = HeaderAdapter(this, R.layout.item_header, mData)
        val header = LayoutInflater.from(this).inflate(R.layout.view_header, null)
        adapter.addHeaderView(header)
        rv_ahf.adapter = adapter

        rv_ahf.layoutManager = LinearLayoutManager(this)
    }

    class HeaderAdapter(
            val context: Context, @LayoutRes val layoutId: Int, val data: List<UserBean>
    ) : BaseRecyclerViewAdapter2<UserBean, BaseViewHolder>(context, layoutId, data) {
        override fun convert(holder: BaseViewHolder, position: Int, item: UserBean) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

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

                //按姓名排序
                res.sortWith(Comparator { u1: UserBean, u2: UserBean -> u1.name.compareTo(u2.name) })
                return res
            }
        }
    }
}
