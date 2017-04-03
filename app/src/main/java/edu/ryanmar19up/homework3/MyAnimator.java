package edu.ryanmar19up.homework3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import android.view.View;

/**
 * This class animates cannonballs being shot from a cannon
 * @author Maggie Ryan
 * */

public class MyAnimator implements Animator, View.OnClickListener {

    //creates cannon, target, cannonball
    Cannon cannon = new Cannon();
    Target target1 = new Target(800,300,50);
    Target target2 = new Target(800,600,50);
    CannonBall cannonBall;

    //# of ticks
    int count = 0;

    //whether to create a new cannonball
    private boolean newCannonBall = false;

    public MyAnimator(){
        newCannonBall=false;
    }

    /**
     * The time interval (in milliseconds) between animation frames. Thus, for
     * example, to draw a frame 20 times per second, you would return 50. This
     * method is called once at the beginning of the animation, so changing the
     * value during the animation will have no effect.
     *
     * @return the time interval (in milliseconds) between calls to this class'
     *         "tick" method.
     */
    @Override
    public int interval(){
        return 50;
    }

    /**
     * The background color with which to paint the canvas before the animation
     * frame is drawn. This method is called at each tick, so the background
     * color can change dynamically by having this method return different
     * values.
     *
     * @return the desired background color
     */
    @Override
    public int backgroundColor(){
        return Color.rgb(230, 230, 250);
    }

    /**
     * Tells whether the animation should be paused.
     *
     * @return a true/false value that says whether the animation should be
     *         paused.
     */
    @Override
    public boolean doPause(){
        return false;
    }

    /**
     * Tells whether the animation should be stopped.
     *
     * @return true/false value that tells whether to terminate the animation.
     */
    @Override
    public boolean doQuit(){
        return false;
    }

    /**
     * Called once every clock tick (frequency specified by the "interval"
     * method) to draw the next animation-frame. Typically this is used to
     * update the animation's data to reflect the passage of time (e.g., to
     * modify an instance variable that gives the position of an object) before
     * the frame is drawn.
     *
     * @param canvas
     *            the Canvas object on which to draw the animation-frame.
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void tick(Canvas canvas){
        count++;

        //draw new cannon
        if(this.newCannonBall == true)
        {
            cannonBall = new CannonBall(8,10);

            if(cannon.rotation>315) {
                cannonBall.vy = (float) (10 - (((cannon.rotation - 315) / 2) * 0.355));
            }
            else if(cannon.rotation<315) {
                cannonBall.vy = (float) (10 + (((315-cannon.rotation)/2)*0.355));
            }
            this.newCannonBall = false;
        }
        if(cannonBall != null) {
            cannonBall.moveSpot(0, -0.08f);
            cannonBall.drawMe(canvas, cannonBall.x, cannonBall.y);
            if(cannonBall.overlaps(target1)){target1.targetHit=true;}
            if(cannonBall.overlaps(target2)){target2.targetHit=true;}
        }

        //draw cannon and target
        cannon.drawMe(canvas, cannon.rotation);
        if(target1.targetHit==true) {
            target1.targetHitDraw(canvas);
        }
        else{target1.drawMe(canvas);}

        if(target2.targetHit==true) {
            target2.targetHitDraw(canvas);
        }
        else{target2.drawMe(canvas);}
    }

    /**
     * Called whenever the user touches the AnimationCanvas so that the
     * animation can respond to the event.
     *
     * @param event a MotionEvent describing the touch
     */
    @Override
    public void onTouch(MotionEvent event){

    }

    /**
     * Responds appropriately to button clicks
     *
     * @param v the clicked button
     */
    public void onClick(View v){
        int buttonSelection = v.getId();

        //Decrease button
        if(buttonSelection == R.id.minus){
            cannon.setRotation(cannon.rotation + 2);
        }
        else if(buttonSelection == R.id.plus){
            cannon.setRotation(cannon.rotation - 2);
        }
        else if(buttonSelection == R.id.fire){
            this.newCannonBall = true;
        }
    }
}

