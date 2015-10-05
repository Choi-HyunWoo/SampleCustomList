package com.hw.corcow.samplecustomlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter mAdapter;

    int[] resIds = {R.drawable.aa13940032, R.drawable.bb6938292};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        mAdapter = new MyAdapter();
        listView.setAdapter(mAdapter);

        // 리스트를 생성했으니 데이터 입력.
        initData();

    }

    private void initData() {
        for (int i = 0; i < 20 ; i++) {
            ItemData d = new ItemData();
            d.title = "Item Title : " + i;
            d.desc = "Item Desc : " + i;
            d.icon = getResources().getDrawable(resIds[i % resIds.length]);
            mAdapter.add(d);
        }
    }
}
