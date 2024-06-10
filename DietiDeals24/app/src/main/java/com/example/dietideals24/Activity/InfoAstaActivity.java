package com.example.dietideals24.Activity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietideals24.Adapter.ListaAdapter;
import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.RetrofitClient;
import com.example.dietideals24.Entities.AstaInglese;
import com.example.dietideals24.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoAstaActivity extends AppCompatActivity {

    private String tipo;
    private String id;
    private String email;
    private ApiService service;

    private boolean scaduta = false;


    public void onBackPressed() {
        Intent intent = new Intent(InfoAstaActivity.this, HomeActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        startActivity(intent);
        finish();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.info_asta_scene);

        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();
        id = getIntent().getSerializableExtra("id").toString();
        service = RetrofitClient.getInstance().create(ApiService.class);

        EditText nome = findViewById(R.id.editTextNome);
        EditText categoria = findViewById(R.id.editTextCategoria);
        EditText offMin = findViewById(R.id.editTextOfferta);
        EditText sogRial = findViewById(R.id.editTextRialzo);
        EditText intTemp = findViewById(R.id.editTextTempo);
        EditText bio = findViewById(R.id.editTextInfo);
        //EditText foto = findViewById(R.id.imageView2);
        EditText utente = findViewById(R.id.UserTextInfo);
        String ultimaOfferta;

        utente.setOnClickListener(v -> {

            Intent intent = new Intent(InfoAstaActivity.this, ProfiloActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("utente", utente.getText().toString());
            intent.putExtra("tipo", tipo);
            intent.putExtra("from", "asta");
            intent.putExtra("id",id);
            startActivity(intent);

        });


        if(tipo.equals("Venditore") || scaduta){
            findViewById(R.id.buttonFaiOfferta).setVisibility(View.INVISIBLE);
        }

        service.infoAsta(id).enqueue(new Callback<AstaInglese>() {
            @Override
            public void onResponse(Call<AstaInglese> call, Response<AstaInglese> response) {

                nome.setText(response.body().getNome());
                categoria.setText(response.body().getCategoria());
                offMin.setText(response.body().getOffertaMinima().toString());
                sogRial.setText(response.body().getSogliaDiRialzo().toString());
                intTemp.setText(response.body().getIntervalloDiTempo().toString());
                bio.setText(response.body().getDescrizione());
                utente.setText(response.body().getUtente());
                //foto.setText(response.body().getFoto());
                


            }

            @Override
            public void onFailure(Call<AstaInglese> call, Throwable t) {
                onBackPressed();

            }
        });

        findViewById(R.id.buttonFaiOfferta).setOnClickListener(v -> {

            Intent intent = new Intent(InfoAstaActivity.this, OffertaActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("tipo", tipo);
            intent.putExtra("offertaAtt", offMin.getText().toString());
            intent.putExtra("soglia", sogRial.getText().toString());
            intent.putExtra("id",id);
            startActivity(intent);
            finish();

        });

    }

}
