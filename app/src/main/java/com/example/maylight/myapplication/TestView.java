package com.example.maylight.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class TestView extends View {
	public TestView(Context context) {
		super(context);
	}

	public TestView(Context context,  AttributeSet attrs) {
		super(context, attrs);
	}

	public TestView(Context context,  AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public TestView(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		Paint paint = new Paint();
//		paint.setStyle(Paint.Style.STROKE);//空心矩形框
		paint.setStyle(Paint.Style.FILL);//实心矩形框
		paint.setColor(0x803268bf);
		canvas.drawRect(new RectF(10, 10, 300, 100), paint);
	}
}
