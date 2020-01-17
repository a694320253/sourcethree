package com.usho.testrecycleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 项目名称：com.usho.testrecycleview
 * 类描述：
 * 作者：   admin .
 * 日期：   2020/1/16 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class SpiderView extends View {
    private Paint radarpaint;
    private Paint valuepaint;

    public SpiderView(Context context) {
        super(context);
    }

    public SpiderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpiderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        radarpaint = new Paint();
        radarpaint.setColor(Color.GREEN);
        radarpaint.setStrokeWidth(10);
        radarpaint.setStyle(Paint.Style.STROKE);

        valuepaint = new Paint();
        valuepaint.setColor(Color.BLUE);
        valuepaint.setStrokeWidth(10);
        valuepaint.setStyle(Paint.Style.FILL);


    }

    private float radus;
    private int radusX;
    private int radusY;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i("TAGTAG","onSizeChanged");
        radus = Math.min(w, h) / 2 * 0.9f;
        radusX = w / 2;
        radusY = h / 2;
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolygon(canvas);
    }

    int count = 6;

    private void drawPolygon(Canvas canvas) {
        Path path = new Path();
        float r = radus / count;
        for (int i = 1; i <= count; i++) {
            float couR = r * i;
            Log.i("TAGTAG","couR--"+couR+"--"+i);
            path.reset();
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    path.moveTo(radusX + couR, radusY);
                } else {
                    float x = (float) (radusX + couR * Math.cos(Math.toRadians(60) * j));
                    float y = (float) (radusY + couR * Math.sin(Math.toRadians(60) * j));
                    path.lineTo(x, y);
                }
            }
            path.close();
            canvas.drawPath(path, radarpaint);
        }
    }
}
