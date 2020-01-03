package com.usho.rain_enoje;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 项目名称：com.usho.rain_enoje
 * 类描述：
 * 作者：   admin .
 * 日期：   2020/1/3 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class RainView extends View {
    private Paint paint;
    private Matrix matrix;
    private Random random;
    private List<ItemEmoge> emogeList;
    private boolean isRun = false;
    private int imgRes = R.mipmap.dog;

    public RainView(Context context) {
        this(context, null);
    }

    public RainView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        matrix = new Matrix();
        random = new Random();
        emogeList = new ArrayList<>();
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isRun) {
            //用于判断下落是否结束  结束不再重绘
            boolean isInScreen = false;
            for (int i = 0; i < emogeList.size(); i++) {
                matrix.reset();
                matrix.setScale(emogeList.get(i).scale, emogeList.get(i).scale);
                emogeList.get(i).x = emogeList.get(i).x + emogeList.get(i).offsetX;
                emogeList.get(i).y = emogeList.get(i).y + emogeList.get(i).offsetY;
                if (emogeList.get(i).y <= getHeight()) {//屏幕内 还存在表情
                    isInScreen = true;

                }
                matrix.postTranslate(emogeList.get(i).x, emogeList.get(i).y);
                canvas.drawBitmap(emogeList.get(i).bitmap, matrix, paint);
            }
            if (isInScreen){
                postInvalidate();
            }else {
                release();
            }

        }

    }

    private void initData() {
        release();
        for (int i = 0; i < 20; i++) {
            ItemEmoge itemEmoge = new ItemEmoge();
            itemEmoge.bitmap = BitmapFactory.decodeResource(getResources(), imgRes);
            //起始横坐标在[100,getwidth()-100]之间
            itemEmoge.x = random.nextInt(getWidth() - 200) + 100;
            //起始纵坐标在[0 ,getHeight]
            itemEmoge.y = -random.nextInt(getHeight());
            itemEmoge.offsetX = random.nextInt(8) - 4;
            itemEmoge.offsetY = 12;
            //缩放  0.8 -> 1.2
            itemEmoge.scale = (random.nextInt(40) + 80) / 100f;
            emogeList.add(itemEmoge);
        }
    }

    public void release() {
        if (emogeList != null && emogeList.size() > 0) {
            for (ItemEmoge itemEmoge : emogeList) {
                if (!itemEmoge.bitmap.isRecycled()) {
                    itemEmoge.bitmap.recycle();
                }
            }
            emogeList.clear();
        }

    }

    public void start(boolean isRun) {
        this.isRun = isRun;
        initData();
        postInvalidate();
    }
}
