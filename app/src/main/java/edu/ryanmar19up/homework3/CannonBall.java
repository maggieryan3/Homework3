package edu.ryanmar19up.homework3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * This class represents a single cannonball on the screen
 * @author Maggie Ryan
 * */

/**
 External Citation
 Date: 31 March 2017
 Problem: Not sure how to do animation.
 Resource: Spot class from lecture
 Solution: I used the code for inspiration throughout this class.
 */

public class CannonBall {

    protected float x; // x-coord
    protected float y; // y-coord
    protected float vx; // velocity in x direction
    protected float vy; // velocity in y direction

    /** this ctor creates a spot at a specified location */
    public CannonBall(float initVX, float initVY)
    {
        // place a spot in the specified location
        x = 0;
        y = 1150;
        vx = initVX;
        vy = initVY;
    }

    /**
     * setPos
     *
     * sets the spot's x,y position.
     *
     * CAVEAT:  Caller is responsible for giving valid values!
     *
     * @param newX the new x position
     * @param newY the new y position
     */
    public void setPos(float newX, float newY)
    {
        this.x = newX;
        this.y = newY;
    }

    /**
     * getPosX
     *
     * gets the spot's x position.
     *
     * @return
     * 	the spot's x-position
     */
    public float getPosX()
    {
        return this.x;
    }

    /**
     * getPosY
     *
     * gets the spot's y position.
     *
     * @return
     * 	the spot's y-position
     */
    public float getPosY()
    {
        return this.y;
    }

    /**
     * Changes the velocity of the spot based on its acceleration. Slows the
     * spot down a bit, to model friction. Adjusts the spot's position based on
     * its velocity. If the change would move the spot outside of a given wall
     * (either 0 or the given wall locations), it bounces, losing about 20% of
     * its velocity as it does.
     *
     * @param aX
     * 		acceleration to apply to the spot (x component)
     * @param aY
     *		acceleration to apply to the spot (y component)
     */
    public void moveSpot(float aX, float aY) {

        // change the velocity based on the acceleration
        vx = vx + aX;
        vy = vy + aY;

        // move the spot based on its velocity
        float newX = x + vx;
        float newY = y - vy;

        this.x = newX;
        this.y = newY;
    }

    /**
     * a spot knows how to draw itself on a given canvas
     *
     * @param canvas
     *            is the canvas to draw upon
     */
    public void drawMe(Canvas canvas, float x , float y) {
        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        canvas.drawCircle(x, y, 25, blackPaint);
    }

    public boolean overlaps(Target target) {
        //Determine the square of the distance between the two
        float xDist = target.x - this.x;
        float yDist = target.y - this.y;
        float distSquared = xDist*xDist + yDist*yDist;

        // determine the sum of the square of the radii of the two spots
        float thisSize = 25;
        float targetSize = 50;
        float sumRadiiSquared = thisSize*thisSize + targetSize*targetSize;

        if (distSquared <= sumRadiiSquared) {
            target.targetHit = true;
            return true;
        }
        return false;
    }//overlaps

}
