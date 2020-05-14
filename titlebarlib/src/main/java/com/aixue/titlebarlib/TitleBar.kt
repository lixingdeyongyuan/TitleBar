package com.aixue.titlebarlib

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.layout_title_bar.view.*


class TitleBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    companion object {
        /**
         * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
         */
        fun dp2px(dpValue: Float): Float {
            return 0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density
        }
    }


    init {
        attrs?.let {
            View.inflate(context, R.layout.layout_title_bar, this)
            var typeArray = context!!.obtainStyledAttributes(attrs, R.styleable.TitleBar)
            var title = typeArray.getString(R.styleable.TitleBar_titleText)
            if (typeArray.hasValue(R.styleable.TitleBar_titleColor)) {
                var titleColor = typeArray.getColorStateList(R.styleable.TitleBar_titleColor)
                tvTitle.setTextColor(titleColor)
            }
            var titleSize = typeArray.getDimension(R.styleable.TitleBar_titleSize, dp2px(16f))
            tvTitle.textSize = titleSize
            tvTitle.text = title

            typeArray.recycle()
        }

    }
}