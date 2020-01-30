package com.example.fragments2.Receitas.Receitas.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeDetailsRecyclerViewAdapter extends RecyclerView.Adapter<RecipeDetailsRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<com.example.fragments2.Receitas.Model.RecipeDetails> recipeDetailsList;

    public RecipeDetailsRecyclerViewAdapter(Context context, List<com.example.fragments2.Receitas.Model.RecipeDetails> movies) {
        this.context = context;
        this.recipeDetailsList = movies;
    }

    @Override
    public RecipeDetailsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ingredients_row,parent,false);
        return new RecipeDetailsRecyclerViewAdapter.ViewHolder(view, context);
    }


    @Override
    public void onBindViewHolder(@NonNull RecipeDetailsRecyclerViewAdapter.ViewHolder holder, int position) {
        com.example.fragments2.Receitas.Model.RecipeDetails recipeDetails = recipeDetailsList.get(position);
        String posterLink = recipeDetails.getImage();
        holder.tittle.setText(recipeDetails.getTitle());

        //Utilizar dependencia picasso para processar imagem
        Picasso.with(context)
                .load(posterLink)
                .placeholder(android.R.drawable.ic_btn_speak_now)
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return recipeDetailsList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tittle;
        ImageView image;


        public ViewHolder(@NonNull View itemView, final Context ctx) {
            super(itemView);
            context = ctx;

            image = itemView.findViewById(R.id.im_ingredit);
            tittle = itemView.findViewById(R.id.tv_ingredient_name);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
