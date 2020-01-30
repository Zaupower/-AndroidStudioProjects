package com.example.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofit {

    @GET("yydcq")

        Call<List<OurDataSet>> getDataSet();
}
