package test.bgl.com.multiprocessdatashare;

import android.app.Activity;
import android.os.Bundle;

public class BProcessActivity extends Activity {

    public static final String contnet = "B Process Private Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_b);
    }
}
