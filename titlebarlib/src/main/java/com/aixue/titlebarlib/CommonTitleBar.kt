package com.aixue.titlebarlib

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.layout_title_bar.view.*
import kotlinx.android.synthetic.main.layout_title_left.view.*

open class CommonTitleBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TitleBar(context, attrs, defStyleAttr) {

    override fun initView(typedArray: TypedArray?) {
        super.initView(typedArray)
        typedArray?.let {
            var titleLeftText = typedArray.getString(R.styleable.TitleBar_titleLeftText)
            var titleLeftSize =
                typedArray.getDimension(R.styleable.TitleBar_titleLeftSize, dip2px(context, 16f))
            var titleLeftColor = typedArray.getColor(
                R.styleable.TitleBar_titleLeftColor,
                ContextCompat.getColor(context, android.R.color.white)
            )
            View.inflate(context, R.layout.layout_title_left, title_left)
            tvLeft.text = titleLeftText
            tvLeft.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleLeftSize)
            tvLeft.setTextColor(titleLeftColor)
        }
    }

    fun setLeftClickListener(onClickListener: OnClickListener) {
        title_left.setOnClickListener(onClickListener)
    }
}