package com.example.fragmentexemplo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentClass extends Fragment {

    private Context context;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);

        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       View mContentView = inflater.inflate(R.layout.my_layout,container,false);
        TextView myText = (TextView) mContentView.findViewById(R.id.my_text);
       return  mContentView;
    }
}
