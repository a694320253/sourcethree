package com.usho.testrecycleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 项目名称：com.usho.testrecycleview
 * 类描述：
 * 作者：   admin .
 * 日期：   2020/1/16 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class RectPoaintView extends View {
    private Paint paint;
    private Rect rect;
    private int pointX = -1;
    private int pointY = -1;

    public RectPoaintView(Context context) {
        super(context);
        init();
    }

    public RectPoaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectPoaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(15);
        paint.setAntiAlias(true);
        rect = new Rect(100, 100, 200, 200);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            pointX= (int) event.getX();
            pointY= (int) event.getY();
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            pointX = -1;
            pointY = -1;
            postInvalidate();
        }
        return super.onTouchEvent(event);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("TAGTAG","onDraw(Canvas canvas)");
        if (rect.contains(pointX, pointY)) {
            paint.setColor(Color.RED);
        } else {
            paint.setColor(Color.GREEN);
        }
        canvas.drawRect(rect, paint);

        Rect rect=new Rect(200,200,400,400);
        canvas.drawRect(rect,paint);

        Rect rect1=new Rect(500,500,800,800);
        paint.setColor(Color.RED);
        canvas.drawRect(rect1,paint);

        rect.union(rect1);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(rect,paint);
    }
}
