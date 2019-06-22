package com.example.snapguess;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    //from folder retrieve 16 images
    //populate into list or array
    //randomize array
    //populate into gridview with this adapter

    private final Context mContext;
    private final Who[] whos;

    public ImageAdapter(Context context, Who[] whos) {
        this.mContext = context;
        this.whos = whos;
    }

    @Override
    public int getCount() {
        return whos.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));
        return dummyTextView;
    }
}
