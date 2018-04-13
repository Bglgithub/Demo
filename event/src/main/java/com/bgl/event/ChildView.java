package com.bgl.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
//import org.gradle.api.DefaultTask;

/**
 * Description: TODO
 * Date: 2018/1/22-${hour}
 * Author: ${user}
 */

public class ChildView extends View implements View.OnClickListener {
    private String TAG = "testEvent";
    public ChildView(Context context) {
        super(context);
    }

    public ChildView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, MainActivity.indexToDesc(event.getAction()) + "  View: dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, MainActivity.indexToDesc(event.getAction()) + "  View: onTouchEvent");
//        if (event.getAction() == 2) {
//            return false;
//        } else {
//            return true;
//        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {

    }
}
