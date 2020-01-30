package com.example.fragments2.Receitas.Receitas.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragments2.R;
import com.example.fragments2.Receitas.Receitas.Data.RecipeDetailsRecyclerViewAdapter;
import com.example.fragments2.Receitas.Receitas.Util.Constantes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetailsDetailActivity extends AppCompatActivity {

    private com.example.fragments2.Receitas.Model.RecipeDetails recipeDetails;
    private RecyclerView recyclerView;
    private List<com.example.fragments2.Receitas.Model.RecipeDetails> recipeDetailsList;

    private RequestQueue queue;
    private RequestQueue instructionsQueue;
    //private String movieId;
    private String recipeID;
    private String instructions;
    private RecipeDetailsRecyclerViewAdapter recipeDetailsRecyclerViewAdapter;

    private ArrayList<String> arrayList2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        callFrag();
        setContentView(R.layout.recipe_details_recycler_view);

        queue = Volley.newRequestQueue(this);

        recipeDetails = (com.example.fragments2.Receitas.Model.RecipeDetails) getIntent().getSerializableExtra("recipeDetails") ;
        recipeDetailsList = new ArrayList<>();
        recipeID = recipeDetails.getId();


        recipeDetailsList = getRecipeDetails(recipeID);

        instructions = getInstrucoes(recipeID);
        recyclerView = findViewById(R.id.recyclerView_ingredients);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipeDetailsRecyclerViewAdapter = new RecipeDetailsRecyclerViewAdapter(getApplicationContext(), recipeDetailsList);
        recyclerView.setAdapter(recipeDetailsRecyclerViewAdapter);
        recipeDetailsRecyclerViewAdapter.notifyDataSetChanged();

    }

    private List<com.example.fragments2.Receitas.Model.RecipeDetails> getRecipeDetails(String recipeID){


        recipeDetailsList.clear();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                Constantes.SPON_URL_LEFT_BY_ID + recipeID + Constantes.SPON_URL_RIGHT_BY_ID, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray recipeArray = response.getJSONArray("ingredients");
                    for (int i=0 ; i<recipeArray.length();++i){

                        JSONObject recipeOBJ = recipeArray.getJSONObject(i);
                        com.example.fragments2.Receitas.Model.RecipeDetails recipeDetails = new com.example.fragments2.Receitas.Model.RecipeDetails();
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

                VolleyLog.d("ERROR" , error.getMessage());
            }

        });

        queue.add(jsonObjectRequest);

        return recipeDetailsList;
    }


    //INSTRUCTIONS

    private String getInstrucoes(String recipeID){

         JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                Constantes.SPON_URL_LEFT_BY_ID + recipeID + Constantes.INSTUCTIONS,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            com.example.fragments2.Receitas.Model.RecipeDetails recipeDetails = new com.example.fragments2.Receitas.Model.RecipeDetails();
                            JSONObject tmpobj = response.getJSONObject(0);
                            JSONArray tmparray = tmpobj.getJSONArray("steps");
                            JSONObject object = tmparray.getJSONObject(0);
                            recipeDetailsList.get(0).setSteps(object.getString("step"));
                            // JSONArray recipeArray = response.getJSONArray("steps");
                            //for (int i=0 ; i<recipeArray.length();++i){

                            //JSONObject recipeOBJ = recipeArray.getJSONObject(i);
                            //recipeDetails.setSteps(recipeOBJ.getString("step"));
                            recipeDetails.setSteps(instructions);
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){
            @Override
            public  void onErrorResponse(VolleyError error){

            }

        });


        instructionsQueue.add(jsonArrayRequest);

        return instructions;
    }
        /*
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                Constantes.SPON_URL_LEFT_BY_ID + recipeID + Constantes.INSTUCTIONS, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


            }
        },new Response.ErrorListener(){
            @Override
            public  void onErrorResponse(VolleyError error){

                VolleyLog.d("ERROR" , error.getMessage());
            }

        });

        queue.add(jsonObjectRequest);

        return instructions;

         */


    public void callFrag() {

        FragmentRecipeInstructions f = new FragmentRecipeInstructions();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_placeHolder_recipeDetails,f,"");
        ft.commit();


    }

}
