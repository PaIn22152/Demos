package com.perdev.recyclerview.test

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlin.math.pow

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview.test
 * Date       2019/12/11 - 15:38
 * Author     Payne.
 * About      类描述：
 */
class TestAdapter(mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        TODO("通过位置position，返回相应的viewType")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("根据不同的viewType，创建相应的viewHolder")
    }

    override fun getItemCount(): Int {
        TODO("返回item的数量")
    }

    override fun onBindViewHolder(viewholer: RecyclerView.ViewHolder, position: Int) {
        TODO("使用viewHolder对象，和相应的位置position，绑定数据到itemView")
    }

    fun singleNumber(nums: IntArray): Int {
        var n = 0
        for (i in nums) {
            n = n xor i
        }
        return n
    }

    fun majorityElement(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }

    fun integerBreak(n: Int): Int {
        if (n <= 3) {
            return n - 1
        }
        val num = n / 3
        val r = n % 3
        if (r == 0) {
            return Math.pow(3.toDouble(), num.toDouble()).toInt()
        }
        return if (r == 1) {
            (Math.pow(3.toDouble(), num.toDouble() - 1) * 4).toInt()
        } else {//r==2
            (Math.pow(3.toDouble(), num.toDouble()) * 2).toInt()
        }
    }

}