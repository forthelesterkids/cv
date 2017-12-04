package com.cv.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cv.model.ListItem;
import com.cv.view.TimestampCallback;

import io.realm.RealmList;

public class ListItemAdapter extends ArrayAdapter<ListItem> implements View.OnClickListener {

    Context mContext;
    int layoutResourceId;
    RealmList<ListItem> data = null;

    public ListItemAdapter(Context mContext, int layoutResourceId, RealmList<ListItem> data) {
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }
        ListItem objectItem = data.get(position);
        TextView textViewItem = (TextView) convertView.findViewById(android.R.id.text1);
        textViewItem.setText(objectItem.getContent());

        convertView.setTag(String.valueOf(position));
        convertView.setOnClickListener(this);
        return convertView;
    }

    public void onClick(View v)
    {
        int pos = Integer.parseInt(v.getTag().toString());
        if(mContext instanceof TimestampCallback) {
            TimestampCallback callback = (TimestampCallback)mContext;
            callback.updateTimestamp(data.get(pos));
        }
    }
}
