package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retroFitTry();

    }

    private void ShowIt(List<OurDataSet> response) {

        DataAdapter dataAdapter = new DataAdapter(response, getApplicationContext());

        recyclerView.setAdapter(dataAdapter);

    }

    public void toast() {
        Toast.makeText(this,"Internet Error", Toast.LENGTH_LONG).show();
    }


    public void retroFitTry() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);
        Call<List<OurDataSet>>listCall = ourRetrofit.getDataSet();
        listCall.enqueue(new Callback<List<OurDataSet>>() {
            @Override
            public void onResponse(Call<List<OurDataSet>> call, Response<List<OurDataSet>> response) {
                ShowIt(response.body());
            }

            @Override
            public void onFailure(Call<List<OurDataSet>> call, Throwable t) {
                toast();
            }
        });

    }

}
