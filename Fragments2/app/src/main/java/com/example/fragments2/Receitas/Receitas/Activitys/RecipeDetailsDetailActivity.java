package com.example.moviedirectory.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.moviedirectory.Data.RecipeDetailsRecyclerViewAdapter;
import com.example.moviedirectory.Model.RecipeDetails;
import com.example.moviedirectory.R;
import com.example.moviedirectory.Util.Constantes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetailsDetailActivity extends AppCompatActivity {

    private RecipeDetails recipeDetails;
    private RecyclerView recyclerView;
    private List<RecipeDetails> recipeDetailsList;

    //spotime


    //

    private RequestQueue queue;
    //private String movieId;
    private String recipeID;
    private  RecipeDetailsRecyclerViewAdapter recipeDetailsRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_details_recycler_view);

        queue = Volley.newRequestQueue(this);
        recipeDetails = (RecipeDetails) getIntent().getSerializableExtra("recipeDetails") ;
        recipeDetailsList = new ArrayList<>();
        recipeID = recipeDetails.getId();

        recipeDetailsList = getMovieDetails2(recipeID);

        recyclerView = findViewById(R.id.recyclerView_ingredients);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipeDetailsRecyclerViewAdapter = new RecipeDetailsRecyclerViewAdapter(getApplicationContext(), recipeDetailsList);
        recyclerView.setAdapter(recipeDetailsRecyclerViewAdapter);
        recipeDetailsRecyclerViewAdapter.notifyDataSetChanged();

    }

    private List<RecipeDetails> getMovieDetails2(String movieId){

        recipeDetailsList.clear();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                Constantes.SPON_URL_LEFT_BY_ID + movieId + Constantes.SPON_URL_RIGHT_BY_ID, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray recipeArray = response.getJSONArray("ingredients");
                    for (int i=0 ; i<recipeArray.length();++i){

                        JSONObject recipeOBJ = recipeArray.getJSONObject(i);
                        RecipeDetails recipeDetails = new RecipeDetails();
                        recipeDetails.setTitle(recipeOBJ.getString("name"));
                        recipeDetails.setImage(recipeOBJ.getString("image"));
                        String newP=Constantes.IMAGE_BASE_URI;
                        newP = newP.concat(recipeDetails.getImage());
                        recipeDetails.setImage(newP);

                        recipeDetailsList.add(recipeDetails);
                    }
                    recipeDetailsRecyclerViewAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public  void onErrorResponse(VolleyError error){

                System.out.println("shit");
                VolleyLog.d("ERROR" , error.getMessage());
            }

        });

        queue.add(jsonObjectRequest);

        return recipeDetailsList;
    }

}
