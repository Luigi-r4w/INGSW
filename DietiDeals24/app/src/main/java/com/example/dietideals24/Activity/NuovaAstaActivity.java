package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.NewAsta;
import com.example.dietideals24.Connection.Service;
import com.example.dietideals24.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NuovaAstaActivity extends AppCompatActivity {

    private String tipo;
    private String email;
    private ApiService service;

    public void onBackPressed() {
        Intent intent = new Intent(NuovaAstaActivity.this, HomeActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        startActivity(intent);
        finish();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.nouva_asta_menu_scene);
        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();
        EditText nome = findViewById(R.id.editTextNome);
        EditText categoria = findViewById(R.id.editTextCategoria);
        EditText offertaMinima = findViewById(R.id.editTextOfferta);
        EditText descrizione = findViewById(R.id.editTextInfo);
        String foto = "";
        EditText interalloTemp = findViewById(R.id.editTextTempo);
        EditText soglia = findViewById(R.id.editTextRialzo);



        findViewById(R.id.leMieAsteButton).setOnClickListener(v->{
            this.setContentView(R.layout.nuova_asta_scene);
        });

        findViewById(R.id.buttonConferma).setOnClickListener(v->{
            NewAsta asta = new NewAsta(nome.getText().toString(), descrizione.getText().toString(), foto, categoria.getText().toString(), offertaMinima.getText().toString(), interalloTemp.getText().toString(), soglia.getText().toString(), "", email);
            service = Service.initialize().create(ApiService.class);
            service.newAsta(asta).enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Intent intent = new Intent(NuovaAstaActivity.this, HomeActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("tipo", tipo);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    Toast.makeText(NuovaAstaActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }
            });

        });

    }
}
