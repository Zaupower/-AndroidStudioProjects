package com.example.recyclerviewtututrial1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class New_Activity extends AppCompatActivity {

    private static final String TAG = "New_Activity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Log.d(TAG, "onCreate: Called");


    }
}