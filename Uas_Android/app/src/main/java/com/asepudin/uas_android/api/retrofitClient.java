package com.asepudin.uas_android.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitClient {
    private static String BASE_URL= "http://192.168.43.24/rest/DataBarang/";
    private static retrofitClient retrofitClient;
    private static Retrofit retrofit;

    public retrofitClient() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
    }

    public static synchronized retrofitClient getInstance(){
        if (retrofitClient==null){
            retrofitClient = new retrofitClient();
        }
        return retrofitClient;
    }

    public api getApi(){
        return retrofit.create(api.class);
    }
}
