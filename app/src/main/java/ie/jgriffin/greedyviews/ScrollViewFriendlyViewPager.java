package ie.jgriffin.greedyviews;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by JGriffin on 13/09/2014.
 *
 * This view was created to allow easy use of a ScrollView within a ViewPager.
 * The override of onInterceptTouchEvent prevents the ScrollView from receiving the
 * touch event unless the swipe is more vertical then horizontal i.e. above 45 degrees.
 */
public class ScrollViewFriendlyViewPager extends ViewPager {

    private float xDistance, yDistance, previousX, previousY;

    //required to allow for slight movement when clicking on an internal view
    private final float touchSlop = 30f;

    public ScrollViewFriendlyViewPager(Context context) {
        super(context);
    }

    public ScrollViewFriendlyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /*From ViewPager source:*/
        /*
         * This method JUST determines whether we want to intercept the motion.
         * If we return true, onMotionEvent will be called and we do the actual
         * scrolling there.
         */
    /*From ViewPager source:*/

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {

            //AKA the Madonna MotionEvent
            //because the pager has been touched for the very first time
            case MotionEvent.ACTION_DOWN:
                //set distances to null
                xDistance = 0f;
                yDistance = 0f;
                //store touch co-ordinates for next event passed to this method
                previousX = ev.getX();
                previousY = ev.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                final float newX = ev.getX();
                final float newY = ev.getY();
                //use absolute value here to account for negative values
                xDistance += Math.abs(newX - previousX);
                yDistance += Math.abs(newY - previousY);
                //store values for next call
                previousX = newX;
                previousY = newY;
                //if angle > 45 degrees
                if (xDistance > yDistance) {
                    //if the x motion is greater then X pixels then intercept
                    return xDistance > touchSlop;
                }
        }
        //else leave normal implementation figure out what to do
        return super.onInterceptTouchEvent(ev);
    }
}
