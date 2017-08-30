package com.test.customepro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static android.R.attr.angle;
import static android.R.attr.pivotX;
import static android.R.attr.pivotY;

/**
 * Created by sage on 17-8-30.
 */

public class PathView extends View {
    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(canvas.getWidth() / 2f, canvas.getHeight() / 2f);
        Path path_srarch = new Path();
        Path path_circle = new Path();

        PathMeasure mMeasure = new PathMeasure();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        // 注意,不要到360度,否则内部会自动优化,测量不能取到需要的数值
        RectF oval1 = new RectF(-50, -50, 50, 50);          // 放大镜圆环
        path_srarch.addArc(oval1, 45, 359.9f);

        RectF oval2 = new RectF(-100, -100, 100, 100);      // 外部圆环
        path_circle.addArc(oval2, 45, -359.9f);

        float[] pos = new float[2];

        mMeasure.setPath(path_circle, false);               // 放大镜把手的位置
        mMeasure.getPosTan(0, pos, null);

        path_srarch.lineTo(pos[0], pos[1]);                 // 放大镜把手
        Log.i("path", "" + pos[0] + "\t" + pos[1]);
        canvas.drawPath(path_circle, paint);
        canvas.drawPath(path_srarch, paint);

        //====================
        // 第一段 pre  顺序执行，先平移(T)后旋转(R)
        Matrix matrix = new Matrix();
        matrix.preTranslate(pivotX, pivotY);
        matrix.preRotate(angle);
        Log.e("Matrix", matrix.toShortString());

        // 第二段 post 逆序执行，先平移(T)后旋转(R)
        Matrix matrix2 = new Matrix();
        matrix2.postRotate(angle);
        matrix2.postTranslate(pivotX, pivotY);
        Log.e("Matrix", matrix2.toShortString());


    }
}
