package ie.jgriffin.greedyviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by JGriffin on 06/09/2014.
 *
 * The override of onInterceptTouchEvent prevents descendant views from receiving the touch event. 
 */
public class GreedyRelativeLayout extends RelativeLayout {
    public GreedyRelativeLayout(Context context) {
        super(context);
    }

    public GreedyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GreedyRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //return super.onInterceptTouchEvent(ev);
        //prevent descendants receiving the touch event
        return true;
    }
}
