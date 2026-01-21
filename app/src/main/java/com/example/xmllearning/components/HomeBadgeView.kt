package com.example.xmllearning.components

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import com.example.xmllearning.R

class HomeBadgeView @JvmOverloads constructor(
    context: Context,
    //naming the attributes
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attributeSet, defStyleAttr) {
    private val label : TextView
    private val icon: ImageView

    init {
        //layout - actual file name
        inflate(context, R.layout.badge, this)

        //linking with UI
        label = findViewById<TextView>(R.id.badgeText)
        icon = findViewById<ImageView>(R.id.badgeIcon)

        //linking the UI with the attributes
        attributeSet?.let {
            context.withStyledAttributes(it, R.styleable.HomeBadgeView){
                icon.setImageResource(
                    getResourceId(R.styleable.HomeBadgeView_badgeIcon, 0)
                )
                label.text = getString(R.styleable.HomeBadgeView_badgeLabel)
            }
        }
    }
}