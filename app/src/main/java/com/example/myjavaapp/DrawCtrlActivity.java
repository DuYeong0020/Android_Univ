package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context MyContxt) {
        super(MyContxt);
        setBackgroundColor(Color.LTGRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint MyPaint = new Paint();
        MyPaint.setAntiAlias(true);
        MyPaint.setColor(Color.GREEN);
        MyPaint.setStrokeWidth(20);
        MyPaint.setTextSize(100);
        canvas.drawText("Text Test", 20, 500, MyPaint);

        MyPaint.setColor(Color.RED);
        canvas.drawLine(100, 100, 300, 500, MyPaint);

        MyPaint.setColor(Color.BLUE);
        MyPaint.setStrokeWidth(0);
        MyPaint.setStyle(Paint.Style.FILL);
        Rect rect1 = new Rect(10, 50, 10+100, 50+100);
        canvas.drawRect(rect1, MyPaint);

        MyPaint.setStrokeWidth(5);
        Path path1 = new Path();
        path1.moveTo(10, 290);
        path1.lineTo(10+50, 290+50);
        path1.lineTo(10+100, 290);
        path1.lineTo(10+150, 290+50);
        path1.lineTo(10+200, 290);

    }
}
public class DrawCtrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_draw_ctrl);

        MyView MyTestVuew = new MyView(this);
        setContentView(MyTestVuew);
    }
}