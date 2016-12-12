package com.junmeng.base.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 封装了绘图线程和背景等的设置
 * Created by HWJ on 2016/12/10.
 */

public abstract class BaseSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {

    DrawThread drawThread;
    Paint paint = new Paint();
    int paintColor = 0xffff0000;

    int screenWidth;//surfaveview宽高
    int screenHeight;

    float screenCenterX;//surfaceView的中心点x坐标
    float screenCenterY;//surfaceView的中心点y坐标

    int drawPauseTime = 50;//一次绘制后休息50ms
    Bitmap bgBitmap = null;//背景图片
    int bgColor = Color.TRANSPARENT;//背景颜色


    public BaseSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BaseSurfaceView(Context context) {
        this(context, null, 0);
    }

    public BaseSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    private void init() {
        //设置画笔
        paint.setColor(paintColor);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setTextSize(20);


        //必须设置此处，否则获取不到touch事件
        setFocusable(true);
        setFocusableInTouchMode(true);
        getHolder().addCallback(this);
        //drawThread = new DrawThread(getHolder());
    }

    /**
     * 设置背景颜色
     *
     * @param color
     */
    public void setBackgroundColor(@ColorInt int color) {
        this.bgColor = color;
    }

    /**
     * 设置背景
     *
     * @param bg
     */
    public void setBackgroundBitmap(Bitmap bg) {
        bgBitmap = bg;
    }


    /**
     * 设置一次绘制后休息时间，默认50ms
     *
     * @param time ms
     */
    public void setDrawPauseTime(int time) {
        drawPauseTime = time;
    }

    @Override
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawThread = new DrawThread(surfaceHolder);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        screenWidth = i1;
        screenHeight = i2;
        screenCenterX = screenWidth / 2.0f;
        screenCenterY = screenHeight / 2.0f;

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        drawThread.stopDraw();
    }

    /**
     * 在此处执行绘制过程
     * @param c
     */
    public abstract void doDraw(Canvas c);

    /**
     * 绘制背景
     * @param canvas
     */
    private void drawBackground(Canvas canvas) {
        if (bgColor == 0) {
            canvas.drawColor(bgColor, PorterDuff.Mode.CLEAR);
        } else {
            canvas.drawColor(bgColor);
        }

        if (bgBitmap != null) {
            try {
                canvas.drawBitmap(Bitmap.createScaledBitmap(bgBitmap, getMeasuredWidth(), getMeasuredHeight(), true), 0, 0, null);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }

    public class DrawThread extends Thread {
        SurfaceHolder surfaceHolder;

        boolean isRunning = true;

        public DrawThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }

        @Override
        public void run() {

            Canvas canvas = null;
            while (isRunning) {
                try {
                    canvas = surfaceHolder.lockCanvas();
                    drawBackground(canvas);
                    doDraw(canvas);

                    if (drawPauseTime > 0) {
                        Thread.sleep(drawPauseTime);//通过它来控制帧数执行一次绘制后休息50ms)
                    }
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        /**
         * 停止绘制
         */
        public void stopDraw() {
            isRunning = false;
        }
    }
}
