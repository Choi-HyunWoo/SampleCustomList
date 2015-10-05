package com.hw.corcow.samplecustomlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Tacademy on 2015-10-05.
 */
public class ItemView extends RelativeLayout {

    public ItemView(Context context) {
        super(context);
        init();
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    ItemData mData;
    ImageView iconView;
    TextView titleView;
    TextView descView;

    // Listener 등록
    public interface OnImageClickListener {
        public void onImageClick(ItemView view, ItemData data);
    }

    OnImageClickListener mListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mListener = listener;
    }


    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_item, this);        // inflate(getContext(), R.layout.view_item, this);

        iconView = (ImageView) findViewById(R.id.imageView);
        iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageClick(ItemView.this, mData);
                }
            }
        });
        titleView = (TextView) findViewById(R.id.textView);
        descView = (TextView) findViewById(R.id.textView2);
    }

    public void setItemData(ItemData data) {
        mData = data;
        if (data.icon != null) {
            iconView.setImageDrawable(data.icon);
        }
        titleView.setText(data.title);
        descView.setText(data.desc);
    }
}
