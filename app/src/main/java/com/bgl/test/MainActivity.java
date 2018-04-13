package com.bgl.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView view = findViewById(R.id.text);
//        int h = view.getMeasuredHeight();
//        int w = view.getMeasuredWidth();
////        Log.d("bgl", "TextView: Height:" + h + " " + w);
//        view.measure(0, 0);
//        h = view.getMeasuredHeight();
//        w = view.getMeasuredWidth();
//        Log.d("bgl", "TextView: \nHeight: " + h + "  width: " + w);

//        int h;
//        int w;
//
//        View content = findViewById(R.id.layout);
////        h = content.getMeasuredHeight();
////        w = content.getMeasuredWidth();
////        Log.d("bgl", "ImageView: Height:" + h + " " + w);
//        content.measure(0, 0);
//        h = content.getMeasuredHeight();
//        w = content.getMeasuredWidth();
//        Log.d("bgl", "LinearLayout: \nheight: " + h + "  width: " + w);




    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
