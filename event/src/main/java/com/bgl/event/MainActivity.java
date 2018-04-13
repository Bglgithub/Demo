package com.bgl.event;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private String TAG = "testEvent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF10C699"));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, indexToDesc(ev.getAction()) + "  Activity: dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, indexToDesc(event.getAction()) + "  Activity: onTouchEvent");
        return super.onTouchEvent(event);
    }

    public static String indexToDesc(int index) {
        if (index == 0) {
            return "ACTION_DOWN";
        }

        if (index == 2) {
            return "ACTION_MOVE";
        }

        if (index == 1) {
            return "ACTION_UP  ";
        }

        if (index == 3) {
            return "ACTION_CANCEL";
        }

        return "ACTION_UNKNOW";
    }
}
