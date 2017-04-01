package edu.ryanmar19up.homework3;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * CannonMainActivity
 *
 * This is the activity for the cannon animation. It creates a AnimationCanvas
 * containing a particular Animator object
 *
 * @author Andrew Nuxoll
 * @author Maggie Ryan
 * @version September 2012
 *
 */
public class CannonMainActivity extends Activity {

    /**
     * creates an AnimationCanvas containing a TestAnimator.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannon_main);

        // Create an animation canvas and place it in the main layout
        Animator myAnim = new MyAnimator();
        AnimationCanvas myCanvas = new AnimationCanvas(this, myAnim);
        LinearLayout mainLayout = (LinearLayout) this
                .findViewById(R.id.top);
        mainLayout.addView(myCanvas);

        //buttons
        Button decrease = (Button)findViewById(R.id.minus);
        decrease.setOnClickListener(new MyAnimator());
        Button increase = (Button)findViewById(R.id.plus);
        increase.setOnClickListener(new MyAnimator());
        Button fire = (Button)findViewById(R.id.fire);
        fire.setOnClickListener(new MyAnimator());

    }

    /**
     * This is the default behavior (empty menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cannon_main, menu);
        return true;
    }
}