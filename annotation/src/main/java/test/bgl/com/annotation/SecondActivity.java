package test.bgl.com.annotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import test.bgl.com.annotation.declaration.Test;
import test.bgl.com.annotationprocessor.FindView;

public class SecondActivity extends AppCompatActivity {

//    @FindView(R.id.text)

    @Test("hello")
    public TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
