package com.usho.testrecycleview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DemoAdapter demoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerView = findViewById(R.id.recycleView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        List<String> list=new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            list.add(i+"");
//        }
//        LinearSnapHelper linearSnapHelper=new LinearSnapHelper();
//        linearSnapHelper.attachToRecyclerView(recyclerView);
//        demoAdapter=new DemoAdapter(list);
//        recyclerView.setAdapter(demoAdapter);
    }
}
