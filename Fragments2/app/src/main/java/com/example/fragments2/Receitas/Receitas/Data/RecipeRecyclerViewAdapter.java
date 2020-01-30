package com.example.fragments2.Receitas.Receitas.Data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments2.R;
import com.example.fragments2.Receitas.Receitas.Activitys.FragmentRecipeInstructions;
import com.example.fragments2.Receitas.Receitas.Activitys.RecipeDetailsDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<com.example.fragments2.Receitas.Model.RecipeDetails> recipeDetailsList;

    public RecipeRecyclerViewAdapter(Context context, List<com.example.fragments2.Receitas.Model.RecipeDetails> recipeDetails) {
        this.context = context;
        this.recipeDetailsList = recipeDetails;
    }


    @Override
    public RecipeRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.receita_row,parent,false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeRecyclerViewAdapter.ViewHolder holder, int position) {

        com.example.fragments2.Receitas.Model.RecipeDetails recipeDetails = recipeDetailsList.get(position);
        String posterLink = recipeDetails.getImage();
        holder.tittle.setText(recipeDetails.getTitle());
        holder.servings.setText(recipeDetails.getReadyInMinutes());
        //Utilizar dependencia picasso para processar imagem
        Picasso.with(context)
                .load(posterLink)
                .placeholder(android.R.drawable.ic_btn_speak_now)
                .into(holder.image);
        //
        holder.readyInMinutes.setText(recipeDetails.getServings());

    }

    @Override
    public int getItemCount() {
        return recipeDetailsList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tittle,readyInMinutes,servings;
        ImageView image;


        public ViewHolder(@NonNull View itemView, final Context ctx) {
            super(itemView);
            context = ctx;

            tittle = itemView.findViewById(R.id.recipeTittleId);
            image = itemView.findViewById(R.id.ImageID);
            readyInMinutes = itemView.findViewById(R.id.readyInMinutesId);
            servings = itemView.findViewById(R.id.servingsId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    com.example.fragments2.Receitas.Model.RecipeDetails recipeDetails = recipeDetailsList.get(getAdapterPosition());
                    Intent intent = new Intent(context, RecipeDetailsDetailActivity.class);

                    intent.putExtra("recipeDetails",  recipeDetails);
                    ctx.startActivity(intent);

                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }

}
