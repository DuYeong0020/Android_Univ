package com.example.myjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.mtp.MtpConstants;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

class MyTouchView extends View {
    public Integer nWidth;
    public Integer nHeight;
    int nXpos, nYpos;
    String sMsg="";
    public MyTouchView(Context Mycontxt) {

        super(Mycontxt);
        setBackgroundColor(Color.GREEN);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint MyPaint = new Paint();
        MyPaint.setAntiAlias(true);


        MyPaint.setColor(Color.YELLOW);
        MyPaint.setStrokeWidth(0);
        MyPaint.setStyle(Paint.Style.FILL);
        Rect rect1 = new Rect(nWidth/2-200, nHeight/2-250, nWidth/2+200, nHeight/2+250);
        canvas.drawRect(rect1, MyPaint);

        MyPaint.setColor(Color.BLUE);
        MyPaint.setTextSize(100);
        // canvas.drawText(nXpos+","+nYpos+"에 클릭", nXpos, nYpos, MyPaint);
        // canvas.drawText(nXpos+","+nWidth+","+nHeight, 100, 150, MyPaint);
        canvas.drawText("해상도 : " + nWidth +", " +nHeight, 100,200, MyPaint);
        canvas.drawText(sMsg, 100,300, MyPaint);
        MyPaint.setColor(Color.BLACK);
        if((nWidth/2-200<=nXpos&&nXpos<=nWidth/2+200)&&(nHeight/2-250<=nYpos&&nYpos<=nHeight/2+250)){
            canvas.drawText("touch!! "+nXpos+", "+nYpos+"에 클릭", nXpos, nYpos, MyPaint);
        }else {
            canvas.drawText(nXpos+", "+nYpos+"에 클릭", nXpos, nYpos, MyPaint);
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        nXpos = (int) event.getX(0);
//        nYpos = (int) event.getY(0);
//
//        invalidate(); // 그리는 놈을 다시 실행해
//        return super.onTouchEvent(event);
        nXpos = (int) event.getX();
        nYpos = (int) event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN)
            sMsg = "ACTION_DOWN";
        if(event.getAction() == MotionEvent.ACTION_MOVE)
            sMsg = "ACTION_MOVE";
        if(event.getAction() == MotionEvent.ACTION_UP)
            sMsg ="ACTION_UP";
        invalidate();
        return true;
    }
}
public class TouchCtrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_ctrl);
        MyTouchView MyTestView = new MyTouchView(this);
        setContentView(MyTestView);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        MyTestView.nWidth = displayMetrics.widthPixels;
        MyTestView.nHeight = displayMetrics.heightPixels;

    }
}