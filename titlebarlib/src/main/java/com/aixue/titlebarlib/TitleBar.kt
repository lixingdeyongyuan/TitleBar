package com.aixue.titlebarlib

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.layout_title_bar.view.*

class TitleBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var mView: View

    companion object {
        private fun dip2px(context: Context, dp: Float): Float {
            return dp * context.getResources().getDisplayMetrics().density + 0.5f;
        }
    }

    init {
        attrs?.let {
            var typedArray = context!!.obtainStyledAttributes(it, R.styleable.TitleBar)
            var isImmersion = typedArray.getBoolean(R.styleable.TitleBar_immersion, false)
            var title = typedArray.getString(R.styleable.TitleBar_titleText)
            var titleSize =
                typedArray.getDimension(R.styleable.TitleBar_titleSize, dip2px(context, 16f))
            mView = View.inflate(context, R.layout.layout_title_bar, this)
            immersionView.visibility = if (isImmersion) View.VISIBLE else View.GONE
            tvTitle.setText(title)
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize)
            typedArray.recycle()
        }
    }

//    fun loadAttributes(attrs: AttributeSet?) {
//        attrs?.let {
//
//        }
//    }


}
