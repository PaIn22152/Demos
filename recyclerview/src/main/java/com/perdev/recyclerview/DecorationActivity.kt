package com.perdev.recyclerview

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.*
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


        //test 1
//        rv_ad.layoutManager = LinearLayoutManager(this, VERTICAL, false)
//        rv_ad.addItemDecoration(SimpleLineDecoration(orientation = VERTICAL,
//                mLine = dp2px(5f),
//                mMargin2 = dp2px(50f),
//                mMargin1 = dp2px(10f)))


        //test 2
//        rv_ad.layoutManager = LinearLayoutManager(this)
//        rv_ad.addItemDecoration(TagDecoration(this, object : TagDecoration.TagCallback {
//            override fun tag(pos: Int): Int {
//                //年龄小于10的，左边显示tag
//                //年龄等于10的，不显示tag
//                //年龄大于10的，右边显示tag
//                return mData[pos].age - 10
//            }
//        }))

        //test 3
//        rv_ad.layoutManager = LinearLayoutManager(this)
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


        //test 4
//        rv_ad.layoutManager = LinearLayoutManager(this)
//        rv_ad.addItemDecoration(PinnedSectionDecoration(object : PinnedSectionDecoration.Callback {
//            override fun getGroupId(position: Int): Int {
//                return Character.toUpperCase(mData[position].name.toCharArray()[0]).toInt()
//            }
//
//            override fun getGroupTitle(position: Int): String {
//                return mData[position].name.substring(0, 1).toUpperCase()
//            }
//
//        }))


        //test 5
        rv_ad.layoutManager = GridLayoutManager(this, 3)
        rv_ad.addItemDecoration(GridDecoration(this, 3))
    }

    companion object {
        fun d(s: String) {
            d("67gnd", s)
        }
    }


    //GridLayoutManager，在每个item之间画一条线，最又边和最下边不画
    class GridDecoration(mContext: Context, val spanCount: Int) : ItemDecoration() {

        private var line: Int = mContext.resources.getDimensionPixelSize(R.dimen.divider_height)
        private val paint: Paint = Paint()

        init {
            paint.color = Color.BLACK
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            val totalCount = state.itemCount
            val pos = parent.childCount - 1
            d("getItemOffsets  pos = $pos   totalCount = $totalCount")
            if (drawBottom(pos, totalCount)) {
                outRect.bottom = line
            }

            if (drawRight(pos)) {
                outRect.right = line
            }

        }

        fun drawRight(pos: Int): Boolean {
            val res = (pos + 1) % 3 != 0
//            d("drawRight  pos = $pos   res = $res")
            return res
        }

        //只考虑每个item都只占一个位置的情况
        fun drawBottom(pos: Int, total: Int): Boolean {
            var num = total % spanCount
            num = if (num == 0) {
                spanCount
            } else {
                num
            }
            return pos + num < total
        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            val childCount = parent.childCount
            val totalCount = state.itemCount

            for (i in 0 until childCount) {
                val view: View = parent.getChildAt(i)
                val pos = parent.getChildAdapterPosition(view)
                d("onDraw  pos = $pos   totalCount = $totalCount")

                if (drawBottom(pos, totalCount)) {
                    c.drawRect(view.left.toFloat(), view.bottom.toFloat(),
                            (view.right + line).toFloat(), (view.bottom + line).toFloat(), paint)
                }

                if (drawRight(pos)) {
                    c.drawRect(view.right.toFloat(), view.top.toFloat(),
                            (view.right + line).toFloat(), (view.bottom + line).toFloat(), paint)
                }
            }

        }
    }

    //粘性头部
    //数据分组，每组数据的title固定在最上方，当下一组title滑到顶部时会顶走上一组title
    class PinnedSectionDecoration(private val callback: Callback) : ItemDecoration() {
        interface Callback {
            fun getGroupId(position: Int): Int
            fun getGroupTitle(position: Int): String
        }

        private val textPaint: TextPaint = TextPaint()
        private val paint: Paint = Paint()
        private val topGap: Int = dp2px(40f)
        private val fontMetrics: Paint.FontMetrics = Paint.FontMetrics()

        init {
            textPaint.typeface = Typeface.DEFAULT_BOLD
            textPaint.isAntiAlias = true//抗锯齿
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
            val itemCount = state.itemCount
            val childCount = parent.childCount
            val left = parent.paddingLeft.toFloat()
            val right = parent.width - parent.paddingRight.toFloat()


            var preGroupId: Int
            var groupId: Int = -1
            d("parent.childCount = " + parent.childCount)
            for (i in 0 until parent.childCount) {
                val view = parent.getChildAt(i)
                val pos = parent.getChildAdapterPosition(view)
                preGroupId = groupId
                groupId = callback.getGroupId(pos)
                if (groupId < 0 || groupId == preGroupId) continue

                d("pos = $pos")

                val viewBottom: Int = view.bottom
                var textY = topGap.coerceAtLeast(view.top).toFloat()
                d("")
                if (pos + 1 < itemCount) { //下一个和当前不一样移动当前
                    val nextGroupId = callback.getGroupId(pos + 1)
                    if (nextGroupId != groupId && viewBottom < textY) { //组内最后一个view进入了header
                        textY = viewBottom.toFloat()
                    }
                }
                c.drawRect(left, textY - topGap, right, textY, paint)

                val title = callback.getGroupTitle(pos)
                val strWidth = textPaint.measureText(title)//文本宽
                val strHeight = abs(textPaint.ascent() + textPaint.descent())//文字高度
                //文字上下居中
                c.drawText(title, left + dp2px(20f), textY - topGap / 2 + strHeight / 2, textPaint)

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
    class SectionDecoration(private val callback: Callback) : ItemDecoration() {

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

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
            super.getItemOffsets(outRect, view, parent, state)
            val pos = parent.getChildAdapterPosition(view)
            if (isGroupFirst(pos)) {
                outRect.top = topGap
            }
        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: State) {
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
    class TagDecoration(mContext: Context, private val tagCallback: TagCallback) : ItemDecoration() {
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

        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: State) {
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


    //简单的分割线
    class SimpleLineDecoration(@ColorInt mColor: Int = Color.parseColor("#33aa99"),
                               val orientation: Int = VERTICAL, val mLine: Int = dp2px(2f),
                               val mMargin1: Int = dp2px(30f), val mMargin2: Int = dp2px(30f))
        : ItemDecoration() {

        private val dividerPaint: Paint = Paint()

        init {
            dividerPaint.color = mColor
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            //除最后一个item外，其余item都在底部设置分割线
            if (state.itemCount != parent.childCount) {
                if (orientation == VERTICAL) {
                    outRect.bottom = mLine
                } else {//HORIZONTAL
                    outRect.right = mLine
                }

            }

        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: State) {
            val childCount = parent.childCount
            if (orientation == VERTICAL) {
                val left = (parent.paddingLeft + mMargin1).toFloat()
                val right = (parent.width - parent.paddingRight - mMargin2).toFloat()
                for (i in 0 until childCount - 1) {
                    val view: View = parent.getChildAt(i)
                    val pos = parent.getChildAdapterPosition(view)
                    val top: Float = view.bottom.toFloat()
                    val bottom: Float = (view.bottom + mLine).toFloat()
                    c.drawRect(left, top, right, bottom, dividerPaint)
                }
            } else {//HORIZONTAL
                val top = (parent.paddingTop + mMargin1).toFloat()
                val bottom = (parent.height - parent.paddingBottom - mMargin2).toFloat()
                for (i in 0 until childCount - 1) {
                    val view: View = parent.getChildAt(i)
                    val pos = parent.getChildAdapterPosition(view)
                    val left: Float = view.right.toFloat()
                    val right: Float = (view.right + mLine).toFloat()
                    c.drawRect(left, top, right, bottom, dividerPaint)
                }
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
        //伴生对象，在内的变量和方法，等同于java中静态变量、静态方法
        companion object {
            fun defData(): ArrayList<UserBean> {
                val res = ArrayList<UserBean>()
                res.add(UserBean("Amy", 13, false))
                res.add(UserBean("Bob", 10))
                res.add(UserBean("Candy", 9, false))
                res.add(UserBean("Don", 11))


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
                res.add(UserBean("Eon", 11))
                res.add(UserBean("Eon", 11))
                res.add(UserBean("Fon", 11))
                res.add(UserBean("Fon", 11))
                res.add(UserBean("Gon", 11))

                //按姓名排序
                res.sortWith(Comparator { u1: UserBean, u2: UserBean -> u1.name.compareTo(u2.name) })
                return res
            }
        }
    }
}
