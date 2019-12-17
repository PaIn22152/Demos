package com.perdev.recyclerview

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextPaint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perdev.recyclerview.base.BaseRecyclerViewAdapter1
import com.perdev.recyclerview.base.BaseViewHolder
import com.perdev.utilslib.d
import com.perdev.utilslib.dp2px
import com.perdev.utilslib.sp2px
import kotlinx.android.synthetic.main.activity_decoration.*
import kotlin.math.abs


class DecorationActivity : AppCompatActivity() {

    /**
     * RecyclerView进阶，Item自定义Decoration
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decoration)

        val mData: ArrayList<UserBean> = ArrayList()
        mData.addAll(UserBean.defData())

        val adapter = Decoration1Adapter1(this, mData)
        rv_ad.adapter = adapter

        rv_ad.layoutManager = LinearLayoutManager(this)

//        val header = LayoutInflater.from(this).inflate(R.layout.view_header, null)
//        rv_ad.addItemDecoration(HeaderDecoration(this, header))

//        rv_ad.addItemDecoration(SimpleLineDecoration(this, mRightPadding = dp2px(50f)))

//        rv_ad.addItemDecoration(TagDecoration(this, object : TagDecoration.TagCallback {
//            override fun tag(pos: Int): Int {
//                //年龄小于10的，左边显示tag
//                //年龄等于10的，不显示tag
//                //年龄大于10的，右边显示tag
//                return data[pos].age - 10
//            }
//        }))


//        rv_ad.addItemDecoration(SectionDecoration(object : SectionDecoration.Callback {
//            override fun getGroupId(position: Int): Int {
//                return Character.toUpperCase(mData[position].name.toCharArray()[0]).toInt()
//            }
//
//            override fun getGroupTitle(position: Int): String {
//                return mData[position].name.substring(0, 1).toUpperCase()
//            }
//
//        }))

//        rv_ad.addItemDecoration(PinnedSectionDecorationOld(this, object : PinnedSectionDecorationOld.DecorationCallback {
//            override fun getGroupId(position: Int): Long {
//                return Character.toUpperCase(mData[position].name.toCharArray()[0]).toLong()
//            }
//
//            override fun getGroupFirstLine(position: Int): String {
//                return mData[position].name.substring(0, 1).toUpperCase()
//            }
//
//        }))

        rv_ad.addItemDecoration(PinnedSectionDecoration(object : PinnedSectionDecoration.Callback {
            override fun getGroupId(position: Int): Int {
                return Character.toUpperCase(mData[position].name.toCharArray()[0]).toInt()
            }

            override fun getGroupTitle(position: Int): String {
                return mData[position].name.substring(0, 1).toUpperCase()
            }

        }))
    }

    companion object {
        fun d(s: String) {
            d("da740", s)
        }
    }

    //数据分组，每组数据的title固定在最上方，当下一组title滑到顶部时会顶走上一组title
    class PinnedSectionDecoration(private val callback: Callback) : RecyclerView.ItemDecoration() {
        interface Callback {
            fun getGroupId(position: Int): Int
            fun getGroupTitle(position: Int): String
        }

        private val textPaint: TextPaint = TextPaint()
        private val paint: Paint = Paint()
        private val topGap: Int = dp2px(50f)
        private val fontMetrics: Paint.FontMetrics = Paint.FontMetrics()

        init {
            textPaint.typeface = Typeface.DEFAULT_BOLD
            textPaint.isAntiAlias = true
            textPaint.textSize = sp2px(20f).toFloat()
            textPaint.color = Color.BLACK
            textPaint.getFontMetrics(fontMetrics)
            textPaint.textAlign = Paint.Align.LEFT

            paint.color = Color.parseColor("#557799")
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            val pos = parent.getChildAdapterPosition(view)
            if (isGroupFirst(pos)) {
                outRect.top = topGap
            }
        }

        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDrawOver(c, parent, state)
            val left = parent.paddingLeft.toFloat()

            val right = parent.width - parent.paddingRight.toFloat()
            for (i in 0 until parent.childCount) {
                val view = parent.getChildAt(i)
                val pos = parent.getChildAdapterPosition(view)
                if (isGroupFirst(pos)) {
                    val top = (view.top - topGap).toFloat()
                    val bottom = view.top.toFloat()
                    c.drawRect(left, top, right, bottom, paint)
                    val title = callback.getGroupTitle(pos)
                    val strWidth = textPaint.measureText(title)//文本宽
                    val strHeight = abs(textPaint.ascent() + textPaint.descent())//文字高度
                    d("strWidth = $strWidth   strHeight = $strHeight")
                    //文字上下居中
                    c.drawText(title, left + dp2px(20f), bottom - topGap / 2 + strHeight / 2, textPaint)
                } else {
                    continue
                }
            }
        }

        private fun isGroupFirst(pos: Int): Boolean {
            if (pos == 0) {
                return true
            }
            val preId = callback.getGroupId(pos - 1)
            val id = callback.getGroupId(pos)
            return preId != id
        }

    }

    //数据分组，每组数据的第一条上方显示title
    class SectionDecoration(private val callback: Callback) : RecyclerView.ItemDecoration() {

        interface Callback {
            fun getGroupId(position: Int): Int
            fun getGroupTitle(position: Int): String
        }

        private val textPaint: TextPaint = TextPaint()
        private val paint: Paint = Paint()
        private val topGap: Int = dp2px(50f)
        private val fontMetrics: Paint.FontMetrics = Paint.FontMetrics()

        init {
            textPaint.typeface = Typeface.DEFAULT_BOLD
            textPaint.isAntiAlias = true
            textPaint.textSize = sp2px(20f).toFloat()
            textPaint.color = Color.BLACK
            textPaint.getFontMetrics(fontMetrics)
            textPaint.textAlign = Paint.Align.LEFT

            paint.color = Color.parseColor("#557799")
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            val pos = parent.getChildAdapterPosition(view)
            if (isGroupFirst(pos)) {
                outRect.top = topGap
            }
        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDraw(c, parent, state)
            val left = parent.paddingLeft.toFloat()
            val right = parent.width - parent.paddingRight.toFloat()
            for (i in 0 until parent.childCount) {
                val view = parent.getChildAt(i)
                val pos = parent.getChildAdapterPosition(view)
                if (isGroupFirst(pos)) {
                    val top = (view.top - topGap).toFloat()
                    val bottom = view.top.toFloat()
                    c.drawRect(left, top, right, bottom, paint)
                    val title = callback.getGroupTitle(pos)
                    val strWidth = textPaint.measureText(title)//文本宽
                    val strHeight = abs(textPaint.ascent() + textPaint.descent())//文字高度
                    d("strWidth = $strWidth   strHeight = $strHeight")
                    //文字上下居中
                    c.drawText(title, left + dp2px(20f), bottom - topGap / 2 + strHeight / 2, textPaint)
                }
            }

        }

        private fun isGroupFirst(pos: Int): Boolean {
            if (pos == 0) {
                return true
            }
            val preId = callback.getGroupId(pos - 1)
            val id = callback.getGroupId(pos)
            return preId != id
        }
    }


    //不同item上显示tag
    class TagDecoration(mContext: Context, private val tagCallback: TagCallback) : RecyclerView.ItemDecoration() {
        interface TagCallback {
            //tag=0 不显示tag   tag<0 左边显示tag   tag>0 右边显示tag
            fun tag(pos: Int): Int
        }

        private val leftPaint: Paint = Paint()
        private val rightPaint: Paint = Paint()
        private val tagWidth: Int = mContext.resources.getDimensionPixelSize(R.dimen.margin)

        init {
            leftPaint.color = mContext.resources.getColor(R.color.colorAccent)
            rightPaint.color = mContext.resources.getColor(R.color.colorPrimary)
        }

        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDrawOver(c, parent, state)
            for (i in 0 until parent.childCount) {
                val child: View = parent.getChildAt(i)
                //item在Adapter中的具体位置，通过此方法获得，而不是直接使用i，i的范围是所有显示的item
                val pos = parent.getChildAdapterPosition(child)
                val tag = tagCallback.tag(pos)
                //tag<0 左边显示tag
                if (tag < 0) {
                    val left: Float = child.left.toFloat()
                    val right = left + tagWidth
                    val top: Float = child.top.toFloat()
                    val bottom: Float = child.bottom.toFloat()
                    c.drawRect(left, top, right, bottom, leftPaint)
                }
                //tag>0 右边显示tag
                else if (tag > 0) {
                    val left: Float = (child.right - tagWidth).toFloat()
                    val right = child.right.toFloat()
                    val top: Float = child.top.toFloat()
                    val bottom: Float = child.bottom.toFloat()
                    c.drawRect(left, top, right, bottom, rightPaint)
                }
            }
        }
    }


    //todo 通过Decoration实现HeaderView，待完成
    class HeaderDecoration(mContext: Context, header: View) : RecyclerView.ItemDecoration() {
        private val headerHeight: Int
        private val dividerPaint: Paint

        init {
            headerHeight = header.measuredHeight
            d(" headerHeight = $headerHeight")
            dividerPaint = Paint()
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            if (parent.childCount == 0) {
                outRect.top = headerHeight
            }
        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDraw(c, parent, state)
            if (parent.childCount == 0) {
                val left = parent.paddingLeft.toFloat()
                val right = parent.width - parent.paddingRight.toFloat()
                val view: View = parent.getChildAt(0)
                val top: Float = view.bottom.toFloat()
                val bottom: Float = (view.bottom + headerHeight).toFloat()
                c.drawRect(left, top, right, bottom, dividerPaint)

            }
        }
    }

    //简单的分割线
    class SimpleLineDecoration(mContext: Context,
                               mLineHeight: Int = -1, mLeftPadding: Int = -1, mRightPadding: Int = -1,
                               @ColorInt mColor: Int = Color.parseColor("#33aa99"))
        : RecyclerView.ItemDecoration() {
        private var dividerHeight: Int = mContext.resources.getDimensionPixelSize(R.dimen.divider_height)
        private var leftMargin: Int = mContext.resources.getDimensionPixelSize(R.dimen.margin)
        private var rightMargin: Int = mContext.resources.getDimensionPixelSize(R.dimen.margin)
        private val dividerPaint: Paint = Paint()

        init {
            dividerPaint.color = mColor
            if (mLineHeight > 0) {
                dividerHeight = mLineHeight
            }
            if (mLeftPadding > 0) {
                leftMargin = mLeftPadding
            }
            if (mRightPadding > 0) {
                rightMargin = mRightPadding
            }
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            //除最后一个item外，其余item都在底部设置分割线
            if (state.itemCount != parent.childCount) {
                outRect.bottom = dividerHeight
            }

        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            val childCount = parent.childCount
            val left = (parent.paddingLeft + leftMargin).toFloat()
            val right = (parent.width - parent.paddingRight - rightMargin).toFloat()
            for (i in 0 until childCount - 1) {
                val view: View = parent.getChildAt(i)
                val top: Float = view.bottom.toFloat()
                val bottom: Float = (view.bottom + dividerHeight).toFloat()
                c.drawRect(left, top, right, bottom, dividerPaint)
            }
        }
    }

    class Decoration1Adapter1(var mContext: Context, var mData: ArrayList<UserBean>) : BaseRecyclerViewAdapter1() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
            val view = LayoutInflater.from(mContext).inflate(R.layout.item_decoration_1, null)
            return MyVHDecoration(view)
        }

        override fun getItemCount(): Int {
            return mData.size
        }

        override fun onBindViewHolder(viewholer: BaseViewHolder, position: Int) {
            super.onBindViewHolder(viewholer, position)
            if (viewholer is MyVHDecoration) {
                val strName = "姓名:" + mData[position].name
                viewholer.setTextViewText(R.id.tv_is1_name, strName)

                val strAge = "年龄:" + mData[position].age
                viewholer.setTextViewText(R.id.tv_is1_age, strAge)
            }
        }

    }

    class MyVHDecoration(itemView: View) : BaseViewHolder(itemView)

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
