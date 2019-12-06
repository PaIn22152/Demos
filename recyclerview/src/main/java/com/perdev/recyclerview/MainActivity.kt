package com.perdev.recyclerview

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * RecyclerView优化demo
     * */
//
//    lateinit var mData: ArrayList<DataBean>
//    lateinit var mAdapter: MainDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        tv_am_s1.setOnClickListener {
            startActivity(Intent(this, SimpleUse1Activity::class.java))
        }

//        rv_data.layoutManager = LinearLayoutManager(this)
//        mData = ArrayList()
//        mData.add(DataBean("title1", "author1", "content1"))
//        mData.add(DataBean("title2", "author2", "content2"))
//        mData.add(DataBean("title3", "author3", "content3"))
//        mData.add(DataBean("title3", "author3", "content3"))
//        mData.add(DataBean("title3", "author3", "content3"))
//        mData.add(DataBean("title3", "author3", "content3"))
//        mData.add(DataBean("title3", "author3", "content3"))
//
//        mData.add(DataBean("Xitle3", "author3", "content3"))
//        mData.add(DataBean("Xitle3", "author3", "content3"))
//        mData.add(DataBean("Xitle3", "author3", "content3"))
//        mData.add(DataBean("Xitle3", "author3", "content3"))
//        mData.add(DataBean("Xitle3", "author3", "content3"))
//        mData.add(DataBean("Xitle3", "author3", "content3"))
//        mData.add(DataBean("Xitle3", "author3", "content3"))
//        mData.add(DataBean("Xitle3", "author3", "content3"))
//
//        mData.add(DataBean("Yitle3", "author3", "content3"))
//        mData.add(DataBean("Yitle3", "author3", "content3"))
//        mData.add(DataBean("Yitle3", "author3", "content3"))
//        mData.add(DataBean("Yitle3", "author3", "content3"))
//        mData.add(DataBean("Yitle3", "author3", "content3"))
//        mData.add(DataBean("Yitle3", "author3", "content3"))
//        mData.add(DataBean("Yitle3", "author3", "content3"))
//        mData.add(DataBean("Yitle3", "author3", "content3"))
//
//        mAdapter = MainDataAdapter(this, mData)
//        rv_data.adapter = mAdapter
//
//        rv_data.addItemDecoration(SimplePaddingDecoration(this))
//        rv_data.addItemDecoration(SimpleDividerDecoration(this))
//        rv_data.addItemDecoration(LeftAndRightTagDecoration(this))
        /*rv_data.addItemDecoration(SectionDecoration(this, object : DecorationCallback {
            override fun getGroupId(position: Int): Long {
                return  Character.toUpperCase(mData[position].title.toCharArray()[0]).toLong()
            }

            override fun getGroupFirstLine(position: Int): String {
                return mData[position].title.substring(0, 1).toUpperCase()
            }
        }))*/

//        rv_data.addItemDecoration(PinnedSectionDecoration(this, object : DecorationCallback {
//            override fun getGroupFirstLine(position: Int): String {
//                return mData[position].title.substring(0, 1).toUpperCase()
//            }
//
//            override fun getGroupId(position: Int): Long {
//                return Character.toUpperCase(mData[position].title.toCharArray()[0]).toLong()
//            }
//        }))


    }
}
