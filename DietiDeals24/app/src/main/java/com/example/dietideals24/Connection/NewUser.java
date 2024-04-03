package com.example.dietideals24.Connection;

import com.google.gson.annotations.SerializedName;

public class NewUser {
    @SerializedName("nome")
    private String nome;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("tipot")
    private String tipo;


    public NewUser(String nome, String email, String password, String tipo) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
    }
}
