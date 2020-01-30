package com.example.retrofittest;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataViewHolder extends RecyclerView.ViewHolder {


    TextView name, hobby, age;
    public DataViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        hobby = itemView.findViewById(R.id.hobby);
        age = itemView.findViewById(R.id.age);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetalhesActivity.class);
                v.getContext().startActivity(intent);

            }
        });

    }


}
