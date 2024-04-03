package com.example.dietideals24.Connection;

import com.google.gson.annotations.SerializedName;

public class NewAsta {
    @SerializedName("nome")
    private String nome;

    @SerializedName("descrizione")
    private String descrizione;

    @SerializedName("foto")
    private String foto;

    @SerializedName("categoria")
    private String categoria;

    @SerializedName("offertaMinima")
    private String offertaMinima;

    @SerializedName("intervalloDiTempo")
    private String intervalloDiTempo;

    @SerializedName("sogliaDiRialzo;")
    private String sogliaDiRialzo;

    @SerializedName("utente")
    private String utente;

    @SerializedName("Integer ultimaOfferta")
    private String ultimaOfferta;




    //asta inglese
    public NewAsta(String nome, String descrizione, String foto, String categoria, String offertaMinima, String intervalloDiTempo, String sogliaDiRialzo, String ultimaOfferta, String utente) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.foto = foto;
        this.categoria = categoria;
        this.offertaMinima = offertaMinima;
        this.intervalloDiTempo = intervalloDiTempo;
        this.sogliaDiRialzo = sogliaDiRialzo;
        this.ultimaOfferta = ultimaOfferta;
        this.utente = utente;
    }

}
