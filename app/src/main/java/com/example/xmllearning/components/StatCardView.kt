package com.example.xmllearning.components

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import com.example.xmllearning.R

class StatCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
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
            context.withStyledAttributes(it, R.styleable.StatCardView) {

                icon.setImageResource(
                    getResourceId(R.styleable.StatCardView_iconSrc, 0)
                )
                value.text = getString(R.styleable.StatCardView_valueText)
                unit.text = getString(R.styleable.StatCardView_unitText)
                label.text = getString(R.styleable.StatCardView_labelText)

            }
        }
    }
}
