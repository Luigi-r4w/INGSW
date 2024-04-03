package com.example.dietideals24.Connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Service {

    private static Retrofit retrofit;

    public Service(){initialize();}
    public static Retrofit initialize(){
        return retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.181:9000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
