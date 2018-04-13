package test.bgl.com.conflictevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Description: TODO
 * Date: 2018/3/30-${hour}
 * Author: ${user}
 */

public class SecondPage extends HorizontalListView {

    public SecondPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        CustomAdapter adapter = createPagerAdapter();
        setAdapter(adapter);
    }

    private CustomAdapter createPagerAdapter() {
        return new CustomAdapter();
    }

    class CustomAdapter extends BaseAdapter {

        public CustomAdapter() {
        }

        @Override
        public int getCount() {
            return 40;
        }

        @Override
        public Object getItem(int position) {
            return "bgl@cwq";
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String string = "bgl@cwq";
            View view = View.inflate(getContext(), R.layout.page_layout, null);
            TextView textView = view.findViewById(R.id.text);
            textView.setText(string);
            return view;
        }
    }
}
