package com.example.fragments2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments2.JogoDasPalavras.StartNewGamePalavras;
import com.example.fragments2.JogoDeMatematica.Start;

public class FragmentA extends Fragment {
    private Button btn, btn5 ;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_jogos_didaticos,container,false);
        btn = v.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(getActivity(), Start.class);
                startActivity(intent);
            }
        });

        btn5 = v.findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), StartNewGamePalavras.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
