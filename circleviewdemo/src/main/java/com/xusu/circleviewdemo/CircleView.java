package com.xusu.circleviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ChaosXu on 2016/06/16 016.
 */
public class CircleView extends View{

        private int mColor;
        private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        public CircleView(Context context) {
                this(context,null);
        }

        public CircleView(Context context, AttributeSet attrs) {
                this(context, attrs,0);
        }

        public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
                super(context, attrs, defStyleAttr);
                TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
                mColor = typedArray.getColor(R.styleable.CircleView_circle_color, Color.RED);
                typedArray.recycle();
                init();
        }

        private void init() {
                paint.setColor(mColor);
        }

        @Override
        protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();

                int width = getWidth() - paddingLeft - paddingRight;
                int height = getHeight() - paddingTop - paddingBottom;

                int radius = Math.min(width, height) / 2;

                canvas.drawCircle(paddingLeft+width/2,paddingTop+height/2,radius,paint);
        }
}
