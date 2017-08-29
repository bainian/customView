package com.test.customepro.view

import android.content.Context
import android.graphics.*
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import com.test.customepro.R
import java.util.*

/**
 * Created by sage on 17-8-29.
 */

class BasicView : View {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {}

    val presents = floatArrayOf(3f, 8f, 9f, 60f, 80f, 105f, 55f, 45f)

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val rectfCommon = RectF(-100f, -100f, 100f, 100f)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(R.color.material_cyan_400)
        val rect = RectF(400f, 150f, 1000f, 750f)
        paint.setColor(ContextCompat.getColor(getContext(), R.color.material_amber_400));
        canvas.drawArc(rect, -5f, -70f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.material_blue_400));
        canvas.drawArc(rect, -5f, 20f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.material_brown_400));
        canvas.drawArc(rect, 15f, 60f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.material_cyan_400));
        canvas.drawArc(rect, 75f, 40f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.material_green_400));
        canvas.drawArc(rect, 115f, 20f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.material_grey_400));
        canvas.drawArc(rect, 135f, 55f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.material_lime_400));
        canvas.drawArc(rect, 190f, 60f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.material_pink_400));

        val matrix = Matrix()
        matrix.postTranslate(-0f, -20f)
        matrix.mapRect(rect)
        canvas.drawArc(rect, 252f, 31f, true, paint);

        paint.setColor(Color.WHITE);
        paint.setTextSize(70f);
        canvas.drawText("饼图", 650f, 900f, paint);

        canvas.translate(0f, 1200f)

        // =============================================================================

        paint.color = Color.WHITE
        paint.strokeWidth = 2f
        val points = floatArrayOf(50f, 50f, 50f, 790 - 80f, 50f, 790 - 80f, canvas.width - 50f, 790 - 80f)
        canvas.drawLines(points, paint)
        val interval = 10f
        val singleWidth = (canvas.width - 50f * 2 - interval * 8) / 9f
        for (i in 0..7) {
            paint.color = Color.argb(255, Random().nextInt(255), Random().nextInt(255), Random().nextInt(255))
            val rect = RectF()
            rect.left = 50f + (i + 1) * interval + i * singleWidth
            rect.right = rect.left + singleWidth
            rect.bottom = 790 - 80f
            rect.top = rect.bottom - presents[i] * 5 - 70
//            rect.top = rect.bottom - (i + 1) * 10f
            canvas.drawRect(rect, paint)
        }

        paint.color = Color.WHITE
        paint.textSize = 50f
        paint.textSize = 60f
        val textBound = Rect()
        val title = "直方图"
        paint.getTextBounds(title, 0, title.length, textBound) //起始 结束
        canvas.drawText(title, (canvas.width - textBound.width()) / 2f, 846f, paint)
        val texts = arrayOf("Froyo", "GB", "ICS", "JB", "KitKat", "L", "M", "O")
        for (i in 0..7) {
            val text = texts[i]
            paint.getTextBounds(text, 0, text.length, textBound)
            canvas.drawText(text, 50f + (i + 1) * interval + i * singleWidth + (singleWidth - textBound.width()) / 2f, 790 - 80f + textBound.height() + 8f, paint)
        }

    }
}


