package com.aixue.titlebarlib

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
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
            var titleColor = typedArray.getColor(
                R.styleable.TitleBar_titleColor,
                ContextCompat.getColor(context, android.R.color.white)
            );
            var rlTitleWidth = typedArray.getDimension(
                R.styleable.TitleBar_rlTitle_width,
                LayoutParams.MATCH_PARENT.toFloat()
            )
            var rlTitleHeight = typedArray.getDimension(
                R.styleable.TitleBar_rlTitle_height,
                LayoutParams.WRAP_CONTENT.toFloat()
            )
            mView = View.inflate(context, R.layout.layout_title_bar, this)
            rlTitle.layoutParams.width = rlTitleWidth.toInt()
            rlTitle.layoutParams.height = rlTitleHeight.toInt()
            immersionView.visibility = if (isImmersion) View.VISIBLE else View.GONE
            if (isImmersion) {
                var drawable = typedArray.getDrawable(R.styleable.TitleBar_immersionBackground)
                if (drawable != null) {
                    immersionView.background = drawable
                } else {
                    immersionView.background = background
                }

            }
            tvTitle.setText(title)
            tvTitle.setTextColor(titleColor)
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize)
            typedArray.recycle()
        }
    }


}
