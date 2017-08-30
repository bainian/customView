package com.test.customepro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.test.customepro.view.Rotate3dAnimation;

/**
 * Created by sage on 17-8-30.
 */

public class Rotate3DActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rotate3d_layout);
        ImageView view = (ImageView) findViewById(R.id.img);
        assert view != null;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 计算中心点（这里是使用view的中心作为旋转的中心点）
                final float centerX = v.getWidth() / 2.0f;
                final float centerY = v.getHeight() / 2.0f;

                //括号内参数分别为（上下文，开始角度，结束角度，x轴中心点，y轴中心点，深度，是否扭曲）
                final Rotate3dAnimation rotation = new Rotate3dAnimation(Rotate3DActivity.this, 0f, 180f, centerX, centerY, 0f, true);

                rotation.setDuration(3000);                         //设置动画时长
                rotation.setFillAfter(true);                        //保持旋转后效果
                rotation.setInterpolator(new LinearInterpolator());    //设置插值器
                v.startAnimation(rotation);
            }
        });
    }
}
