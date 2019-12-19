package com.example.fragmentex1f5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class fragmentA extends Fragment {
    private EditText mContext;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mContentView = inflater.inflate(R.layout.activity_main, container, false);
        btn = (Button) mContentView.findViewById(R.id.button2);
        mContext = (EditText) mContentView.findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datapass = mContext.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("Contexto",datapass);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment,fragmentB);
                fragmentTransaction.commit();
            }
        });
        return mContentView;
    }

}
