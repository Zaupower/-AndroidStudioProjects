package com.example.recipeinstrutionstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url = "https://api.spoonacular.com/recipes/324694/analyzedInstructions?apiKey=796536a0598e4d5b984a2425d42ed88a";
    private Button btn;
    private TextView tv;
    private RequestQueue queue;
    private JsonArrayRequest jsonArrayRequest;

    private List<PassosDaReceita> receitaList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button2);
        tv = findViewById(R.id.tv_result);

        queue = Volley.newRequestQueue(this);

        receitaList = new ArrayList<>();

        receitaList = sendRequest();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private List<PassosDaReceita> sendRequest() {


        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            JSONObject tmpobj = response.getJSONObject(0);
                            JSONArray steps = tmpobj.getJSONArray("steps");

                            PassosDaReceita passosDaReceita = new PassosDaReceita();
                            for (int i=0; i<steps.length();i++){
                                JSONObject object = steps.getJSONObject(i);
                                String step =  object.getString("step");
                                passosDaReceita.setPasso(step);
                                System.out.println(step);
                                receitaList.add(passosDaReceita);
                            }


                        }catch (Exception e){

                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("ERROR" , error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
        return receitaList;
    }

}