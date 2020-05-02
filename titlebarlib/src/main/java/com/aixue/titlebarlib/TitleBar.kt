package com.aixue.titlebarlib

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.layout_title_bar.view.*

class TitleBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {



    init {
        attrs?.let {
            View.inflate(context, R.layout.layout_title_bar, this)
            var typeArray = context!!.obtainStyledAttributes(attrs, R.styleable.TitleBar)
            var title = typeArray.getString(R.styleable.TitleBar_titleText)
            if (typeArray.hasValue(R.styleable.TitleBar_titleColor)) {
                var titleColor = typeArray.getColorStateList(R.styleable.TitleBar_titleColor)
                tvTitle.setTextColor(titleColor)
            }

            tvTitle.text = title

            typeArray.recycle()
        }

    }
}