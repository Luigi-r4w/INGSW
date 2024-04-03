package com.example.dietideals24.Connection;

import com.google.gson.annotations.SerializedName;

public class UserCheck {
    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("tipo_account")
    private String tipo;

    public UserCheck(String email, String password, String tipo) {
        this.email = email;
        this.password = password;
        this.tipo = tipo;
    }
}
