package com.dinesh.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomCircleView @JvmOverloads constructor(
    context : Context,
    attrs : AttributeSet? = null,
    defStyleAttr : Int = 0,
) : View(context, attrs, defStyleAttr) {

    private var circleColor: Int = Color.RED
    private var circleRadius: Float = 100f

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomCircleView,
            0, 0
        ).apply {
            try {
                circleColor = getColor(R.styleable.CustomCircleView_circleColor, Color.RED)
                circleRadius = getDimension(R.styleable.CustomCircleView_circleRadius, 100f)
            } finally {
                recycle()
            }
        }
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = width.coerceAtLeast(height) / 2f
        canvas.drawCircle(width / 2f, height / 2f, radius, paint)
    }



}