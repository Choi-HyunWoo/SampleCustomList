package com.hw.corcow.samplecustomlist;

import android.content.ClipData;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2015-10-05.
 */
public class MyAdapter extends BaseAdapter {
    List<ItemData> items = new ArrayList<ItemData>();

    public void add(ItemData item) {
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ItemData getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView view = new ItemView(parent.getContext());
        view.setItemData(items.get(position));
        return view;
    }
}
