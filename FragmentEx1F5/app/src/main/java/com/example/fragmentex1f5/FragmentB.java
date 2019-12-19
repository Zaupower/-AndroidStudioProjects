package com.example.fragmentex1f5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mContentView = inflater.inflate(R.layout.activity_main, container, false);

        Bundle bundle = getArguments();

        String contexto = bundle.getString("Contexto");

        TextView contexto2 = (TextView) mContentView.findViewById(R.id.textView);

        contexto2.setText(contexto);
        return  mContentView;
    }

}
