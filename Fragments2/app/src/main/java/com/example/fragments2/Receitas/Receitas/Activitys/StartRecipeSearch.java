package com.example.fragments2.Receitas.Receitas.Activitys;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragments2.R;
import com.example.fragments2.Receitas.Receitas.Data.RecipeRecyclerViewAdapter;
import com.example.fragments2.Receitas.Receitas.Util.Constantes;
import com.example.fragments2.Receitas.Receitas.Util.Prefs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StartRecipeSearch extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecipeRecyclerViewAdapter movieRecyclerViewAdapter;

    private List<com.example.fragments2.Receitas.Model.RecipeDetails> recipeDetailsList;
    private RequestQueue requestQueue;
    //private AlertDialog.Builder alertDialogBuilder;
    //private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recipes);

        requestQueue = Volley.newRequestQueue(this);

        //inputDialog
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showInputDialog();
            }
        });
        //

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Prefs prefs = new Prefs(StartRecipeSearch.this);
        String search = prefs.getSearch();

        recipeDetailsList = new ArrayList<>();
        recipeDetailsList = getMovieList(search);

        movieRecyclerViewAdapter = new RecipeRecyclerViewAdapter(this, recipeDetailsList);
        recyclerView.setAdapter(movieRecyclerViewAdapter);
        movieRecyclerViewAdapter.notifyDataSetChanged();

    }

    public List<com.example.fragments2.Receitas.Model.RecipeDetails> getMovieList(String searchTerm){
        recipeDetailsList.clear();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                Constantes.SPON_SEARCH + searchTerm + Constantes.SPOON_API_KEY, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try{

                    JSONArray recipeArray = response.getJSONArray("results");
                    for (int i=0 ; i<recipeArray.length();++i){

                        JSONObject recipeOBJ = recipeArray.getJSONObject(i);
                        com.example.fragments2.Receitas.Model.RecipeDetails recipeDetails = new com.example.fragments2.Receitas.Model.RecipeDetails();
                        recipeDetails.setTitle(recipeOBJ.getString("title"));
                        recipeDetails.setReadyInMinutes(recipeOBJ.getString("readyInMinutes"));
                        recipeDetails.setServings(recipeOBJ.getString("servings"));
                        recipeDetails.setImage(recipeOBJ.getString("image"));
                        //contactenate image url with base url
                        String newP=Constantes.IMAGE_BASE_URI;
                        newP = newP.concat(recipeDetails.getImage());
                        recipeDetails.setImage(newP);
                        //
                        recipeDetails.setImage(newP);
                        recipeDetails.setId(recipeOBJ.getString("id"));

                        Log.d("Recipes", recipeDetails.getTitle());

                        recipeDetailsList.add(recipeDetails);
                    }
                    movieRecyclerViewAdapter.notifyDataSetChanged();

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener(){
            @Override
            public  void onErrorResponse(VolleyError error){

            }

        });
        requestQueue.add(jsonObjectRequest);

        return recipeDetailsList;
    }

    //SponnTime
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.fab);
        return super.onOptionsItemSelected(item);
    }

/*
    public void showInputDialog(){

        alertDialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_view, null);
        final EditText newSearchEdt = findViewById(R.id.searchEdt);
        Button submitButton = findViewById(R.id.submit_btn);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();

        dialog.show();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prefs prefs = new Prefs(StartRecipeSearch.this);

                if (!newSearchEdt.getText().toString().isEmpty()){
                    String search = newSearchEdt.getText().toString();
                    movieList.clear();

                    getMovieList(search);

                    movieRecyclerViewAdapter.notifyDataSetChanged();
                }
                dialog.dismiss();
            }
        });
    }
*/

}
