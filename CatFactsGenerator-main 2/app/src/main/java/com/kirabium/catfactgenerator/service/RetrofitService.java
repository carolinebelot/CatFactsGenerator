package com.kirabium.catfactgenerator.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final Gson gson = new GsonBuilder().setLenient().create();
    private static final OkHttpClient httpClient = new OkHttpClient.Builder().build();
    private static final String BASE_URL = "https://catfact.ninja/";
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public static ApiInterface getInterface() {
        return retrofit.create(ApiInterface.class);
    }
}