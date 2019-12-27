package com.example.listviewtest;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ListItem> listItems = new ArrayList<>();

        for (int i=0;i<11;++i) {
            ListItem item;
            item = new ListItem(
                    "Item" + (i + 1),
                    "Description"
            );
            listItems.add(item);
        }
        RecyclerView.Adapter adapter = new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }
}