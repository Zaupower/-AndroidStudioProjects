package com.example.recycler2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //inicializacao da array list
    private ArrayList<String> mList = new ArrayList<String>();

    private MyListAdapter mAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyListAdapter(MyListActivity.this, mList);
        setListAdapter(mAdapter);
    }
}
