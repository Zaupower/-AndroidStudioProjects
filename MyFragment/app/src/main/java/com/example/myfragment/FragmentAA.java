package com.example.myfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentAA extends Fragment {
    private EditText editText;
    private Button button;
    IMainActivity iMainActivity = new MainActivity();
    FragmentBB fragmentBB = new FragmentBB();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_fragment_a,container,false);
        editText = v.findViewById(R.id.editText);
        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //
                iMainActivity.passData(editText.getText().toString(),fragmentBB);
                //
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentMain, fragmentBB);
                fragmentTransaction.commit();
            }
        });
        return v;
    }


}
