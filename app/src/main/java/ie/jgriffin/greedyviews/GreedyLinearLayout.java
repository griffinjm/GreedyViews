package ie.jgriffin.greedyviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by JGriffin on 06/09/2014.
 */
public class GreedyLinearLayout extends LinearLayout {
    public GreedyLinearLayout(Context context) {
        super(context);
    }

    public GreedyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public GreedyLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //return super.onInterceptTouchEvent(ev);
        //prevent the touch event being passed to the children of this view
        return true;
    }
}
