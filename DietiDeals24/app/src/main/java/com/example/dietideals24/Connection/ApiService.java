package com.example.dietideals24.Connection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/check_venditore/")
    Call<Boolean> checkUser(@Body UserCheck request);

    @POST("/nuovo_utente")
    Call<Boolean> newUser(@Body NewUser request);

    @POST("/nuovo_utente")
    Call<Boolean> newAsta(@Body NewAsta request);

}
