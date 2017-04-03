package edu.ryanmar19up.homework3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * This class represents a single cannon on the screen
 * @author Maggie Ryan
 * */

public class Cannon {

    int rotation;

    public Cannon(){
        rotation = 315;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawMe(Canvas c, int rotation){
        Paint grayPaint = new Paint();
        grayPaint.setColor(Color.DKGRAY);
        c.save();
        c.rotate(rotation,0,1150);
        c.drawOval(0, 1050, 400, 1250, grayPaint);
        c.restore();
    }

    public void setRotation(int rotation)
    {
        this.rotation = rotation;
    }
}
