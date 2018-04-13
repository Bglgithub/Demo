package test.bgl.com.conflictevent;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter = createPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
    }

    private PagerAdapter createPagerAdapter() {
        return new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View item;
                if (position == 1) {
                    item = MainActivity.this.getLayoutInflater().inflate(R.layout.second_page_layout, null);
                } else {
                     item = MainActivity.this.getLayoutInflater().inflate(R.layout.page_layout, null);
                    TextView textView = item.findViewById(R.id.text);
                    textView.setText("Parent ViewPager" + (position+1));
                }
                container.addView(item);
                return item;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
            }
        };
    }
}
