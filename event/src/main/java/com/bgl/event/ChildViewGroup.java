package com.bgl.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Description: TODO
 * Date: 2018/1/22-${hour}
 * Author: ${user}
 */

public class ChildViewGroup extends FrameLayout {
    private String TAG = "testEvent";
    public ChildViewGroup(Context context) {
        super(context);
    }

    public ChildViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, MainActivity.indexToDesc(ev.getAction()) + "  ChildViewGroup: dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, MainActivity.indexToDesc(ev.getAction()) + "  ChildViewGroup: onInterceptTouchEvent");
//        if (ev.getAction() == 0) {
//            return false;
//        } else {
//            return true;
//        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, MainActivity.indexToDesc(event.getAction()) + "  ChildViewGroup: onTouchEvent");
        return super.onTouchEvent(event);
    }
}
