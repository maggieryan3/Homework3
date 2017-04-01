package edu.ryanmar19up.homework3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * This class represents a single target on the screen
 * @author Maggie Ryan
 * */

public class Target {

    int x;
    int y;
    int r;
    boolean targetHit = false;

    public Target(int initX, int initY, int initR){
        this.x = initX;
        this.y = initY;
        this.r = initR;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawMe(Canvas c){
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        c.drawCircle(this.x,this.y,this.r,redPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void targetHitDraw(Canvas c){
        Paint greenPaint = new Paint();
        greenPaint.setColor(Color.GREEN);
        c.drawCircle(this.x,this.y,this.r,greenPaint);
    }
}
