package test.bgl.com.annotation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import test.bgl.com.annotation.declaration.FindViewRT;
import test.bgl.com.annotation.processor.InjectCtrl;
import test.bgl.com.annotationprocessor.FindView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @FindViewRT(R.id.text)
    public TextView mTextView;

    @FindViewRT(R.id.img)
    public ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        InjectCtrl.bind(this);
        InjectCtrl.bindView(this);


        if (mTextView != null && mImageView != null) {
            mTextView.setText("TextView 绑定成功!");
        }
        mTextView.setTextAppearance(this, 0);
    }

    @Override
    public void onClick(@NonNull View v) {

    }
}
