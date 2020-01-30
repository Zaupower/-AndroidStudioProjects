package com.example.fragments2;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.fragments2.Receitas.Receitas.Activitys.StratRecipeSearch;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_b extends Fragment {


    private Button pesquisa_btn, analisa_btn ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_receitas,container,false);
        pesquisa_btn = v.findViewById(R.id.btn_pesquisa_receitas);
        pesquisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(getActivity(), StratRecipeSearch.class);
                startActivity(intent);
            }
        });

        /*
        btn5 = v.findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), StartNewGamePalavras.class);
                startActivity(intent);
            }
        });*/
        return v;
    }

}
