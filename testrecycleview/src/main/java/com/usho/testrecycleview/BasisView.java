package com.usho.testrecycleview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
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
public class BasisView extends View {
    Paint paint;
    private Paint linePaint;

    public BasisView(Context context) {
        this(context, null);
    }

    public BasisView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BasisView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(50);
        paint.setAntiAlias(true);

        linePaint=new Paint();
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(10);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setAntiAlias(true);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(255, 0, 255);
        Log.i("TAGTAG", "onDraw");
        canvas.drawCircle(190, 200, 150, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0x7eefff00);
        canvas.drawCircle(190, 200, 150, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(0x7eefff00);
        canvas.drawCircle(190, 600, 150, paint);

        paint.setColor(Color.BLACK);
        canvas.drawLine(190, 200, 190, 600, paint);

        paint.setStrokeWidth(15);
        paint.setColor(Color.GREEN);
        canvas.drawPoint(190, 400, paint);


        canvas.drawRect(400, 10, 800, 210, paint);

        RectF rectF = new RectF(400, 250, 800, 450);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rectF, paint);


        Path path=new Path();
        path.moveTo(400,800);
        path.lineTo(400,1200);
        path.lineTo(800,1200);
        path.close();
        canvas.drawPath(path,linePaint);


        Path arcPath=new Path();
        arcPath.moveTo(300,1200);
        RectF rectF1=new RectF(100,10,200,100);
        arcPath.arcTo(rectF1,0,90,false);
        linePaint.setColor(Color.WHITE);
//        linePaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(arcPath,linePaint);
    }
}
