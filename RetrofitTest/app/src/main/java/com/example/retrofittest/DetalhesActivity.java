package com.example.retrofittest;

import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesActivity extends AppCompatActivity {

    private static final String TAG = "DetalhesActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes);
        Log.d(TAG, "onCreate:Started ");
    }
}
