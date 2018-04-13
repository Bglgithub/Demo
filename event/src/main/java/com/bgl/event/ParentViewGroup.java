package com.bgl.event;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Description: TODO
 * Date: 2018/1/22-${hour}
 * Author: ${user}
 */

public class ParentViewGroup extends FrameLayout {

    private String TAG = "testEvent";

    public ParentViewGroup(@NonNull Context context) {

        super(context);
    }

    public ParentViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, MainActivity.indexToDesc(ev.getAction()) + "  ParentViewGroup: dispatchTouchEvent");
//        int id = ev.getActionIndex();
//        Log.d(TAG, "ActionIndex: " + ev.getPointerId(id));
//        Log.d(TAG, MainActivity.indexToDesc(ev.getAction()) + "  ParentViewGroup: dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, MainActivity.indexToDesc(ev.getAction()) + "  ParentViewGroup: onInterceptTouchEvent");
        if (ev.getAction() != MotionEvent.ACTION_DOWN) {
            return true;
        } else {
            return super.onInterceptTouchEvent(ev);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, MainActivity.indexToDesc(event.getAction()) + "  ParentViewGroup: onTouchEvent");
        return super.onTouchEvent(event);
    }
}
