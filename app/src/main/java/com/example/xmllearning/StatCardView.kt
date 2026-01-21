package com.example.xmllearning

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class StatCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val icon: ImageView
    private val value: TextView
    private val unit: TextView
    private val label: TextView

    init {
        inflate(context, R.layout.stats_card, this)

        icon = findViewById(R.id.stat_icon)
        value = findViewById(R.id.stat_value)
        unit = findViewById(R.id.stat_unit)
        label = findViewById(R.id.stat_label)

        attrs?.let {
            orientation = VERTICAL
            val ta = context.obtainStyledAttributes(it, R.styleable.StatCardView)

            icon.setImageResource(
                ta.getResourceId(R.styleable.StatCardView_iconSrc, 0)
            )
            value.text = ta.getString(R.styleable.StatCardView_valueText)
            unit.text = ta.getString(R.styleable.StatCardView_unitText)
            label.text = ta.getString(R.styleable.StatCardView_labelText)

            ta.recycle()
        }
    }
}
