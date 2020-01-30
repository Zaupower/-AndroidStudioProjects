package com.example.recyclerviewtututrial1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnNoteListener {


    private static final String TAG = "MainActivity";
    List<ListItem> listItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        for (int i=0;i<8;++i) {
            ListItem item;
            item = new ListItem(
                    "Item" + (i + 1),
                    "Description"
            );
            listItems.add(item);
        }
        RecyclerView.Adapter adapter = new MyAdapter(this, listItems,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onNoteClick(int position) {

        //listItems.get(position);
        Intent intent = new Intent(this, New_Activity.class);
        startActivity(intent);
        Log.d(TAG, "onNoteClick: Clicked");
    }
}
