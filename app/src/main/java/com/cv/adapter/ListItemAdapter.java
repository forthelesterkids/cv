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

    private final Context context;
    private final int layoutResourceId;
    private final RealmList<ListItem> listItems;

    public ListItemAdapter(Context context, int layoutResourceId, RealmList<ListItem> listItems) {
        super(context, layoutResourceId, listItems);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.listItems = listItems;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }
        ListItem objectItem = listItems.get(position);
        TextView textViewItem = (TextView) convertView.findViewById(android.R.id.text1);
        textViewItem.setText(objectItem.getContent());

        convertView.setTag(String.valueOf(position));
        convertView.setOnClickListener(this);
        return convertView;
    }

    public void onClick(View v)
    {
        int pos = Integer.parseInt(v.getTag().toString());
        if(context instanceof TimestampCallback) {
            TimestampCallback callback = (TimestampCallback)context;
            callback.updateTimestamp(listItems.get(pos));
        }
    }
}
