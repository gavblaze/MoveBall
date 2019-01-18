package com.gavblaze.android.moveball;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class DrawBallCustomView extends View {

    private static final int DEFAULT_CIRCLE_RADIUS = 80;
    private Paint mCirclePaint;
    private float mCirclePositionX, mCirclePositionY;
    private int mRadius;
    private int mCircleColor;

    public DrawBallCustomView(Context context) {
        super(context);
        init(null);
    }

    public DrawBallCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DrawBallCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawBallCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {

        mCirclePaint = new Paint();

        if (attrs == null) return;

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.DrawBallCustomView);

        mRadius = typedArray.getDimensionPixelSize(R.styleable.DrawBallCustomView_circle_radius, DEFAULT_CIRCLE_RADIUS);
        mCircleColor = typedArray.getColor(R.styleable.DrawBallCustomView_circle_color, Color.RED);

        typedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mCirclePaint.setColor(getmCircleColor());

        if (mCirclePositionX == 0f || mCirclePositionY == 0f) {
            mCirclePositionX = getWidth() / 2;
            mCirclePositionY = getHeight() / 2;
        }
        canvas.drawCircle(getmCirclePositionX(), getmCirclePositionY(), mRadius, mCirclePaint);
    }




    public float getmCirclePositionX() {
        return mCirclePositionX;
    }

    public void setmCirclePositionX(float mCirclePositionX) {
        this.mCirclePositionX = mCirclePositionX;
    }

    public float getmCirclePositionY() {
        return mCirclePositionY;
    }

    public void setmCirclePositionY(float mCirclePositionY) {
        this.mCirclePositionY = mCirclePositionY;
    }

    public int getmCircleColor() {
        return mCircleColor;
    }

    public void setmCircleColor(int mCircleColor) {
        this.mCircleColor = mCircleColor;
    }

    public int getmRadius() {
        return mRadius;
    }

    public void setmRadius(int mRadius) {
        this.mRadius = mRadius;
    }
}
