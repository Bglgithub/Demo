package test.bgl.com.annotation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import test.bgl.com.annotationprocessor.FindView;


/**
 * Description: TODO
 * Date: 2018/4/12-${hour}
 * Author: ${user}
 */

public class CustomAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    class ViewHolder {
        @FindView(R.id.img)
        public ImageView mImg;

        @FindView(R.id.text)
        public TextView mTxt;
    }
}
