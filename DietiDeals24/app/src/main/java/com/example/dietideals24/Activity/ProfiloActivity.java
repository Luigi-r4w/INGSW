package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietideals24.Adapter.NotificaAdapter;
import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.RetrofitClient;
import com.example.dietideals24.Entities.Compratore;
import com.example.dietideals24.Entities.Notifica;
import com.example.dietideals24.Entities.Venditore;
import com.example.dietideals24.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfiloActivity extends AppCompatActivity {

    private ApiService service;
    private String tipo;
    private String email;

    public void onBackPressed() {
        Intent intent = new Intent(ProfiloActivity.this, HomeActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        startActivity(intent);
        finish();
    }
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.profilo_scene);

        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();
        service = RetrofitClient.getInstance().create(ApiService.class);

        EditText nome = findViewById(R.id.editTextNome);
        EditText mail = findViewById(R.id.editTextEmail);
        EditText link = findViewById(R.id.editTextlink);
        EditText posizione = findViewById(R.id.editTextPosizione);
        EditText bio = findViewById(R.id.editTextBio);
        EditText pass = findViewById(R.id.editTextPassword);

        if (tipo.equals("Compratore")){

            service.getCompratore(email).enqueue(new Callback<Compratore>() {
                @Override
                public void onResponse(Call<Compratore> call, Response<Compratore> response) {

                    nome.setText(response.body().getNome());
                    mail.setText(response.body().getEmail());
                    link.setText(response.body().getLink());
                    posizione.setText(response.body().getPosizione());
                    bio.setText(response.body().getDescrizione());
                    pass.setText(response.body().getPassword());

                }

                @Override
                public void onFailure(Call<Compratore> call, Throwable t) {
                    Toast.makeText(ProfiloActivity.this, "Errore", Toast.LENGTH_SHORT).show();

                }
            });

        } else {

            service.getVenditore(email).enqueue(new Callback<Venditore>() {
                @Override
                public void onResponse(Call<Venditore> call, Response<Venditore> response) {

                    nome.setText(response.body().getNome());
                    mail.setText(response.body().getEmail());
                    link.setText(response.body().getLink());
                    posizione.setText(response.body().getPosizione());
                    bio.setText(response.body().getDescrizione());
                    pass.setText(response.body().getPassword());

                }

                @Override
                public void onFailure(Call<Venditore> call, Throwable t) {
                    Toast.makeText(ProfiloActivity.this, "Errore", Toast.LENGTH_SHORT).show();

                }
            });

        }

        findViewById(R.id.buttonModifica).setOnClickListener(view -> {
            if (tipo.equals("Compratore")){

                Compratore user = new Compratore();
                user.setNome(nome.getText().toString());
                user.setEmail(email);
                user.setPassword(pass.getText().toString());
                user.setLink(link.getText().toString());
                user.setDescrizione(bio.getText().toString());
                user.setPosizione(posizione.getText().toString());

                service.updateCompratore(user).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                        onBackPressed();

                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                        onBackPressed();

                    }
                });

            } else {

                Venditore user = new Venditore();
                user.setNome(nome.getText().toString());
                user.setEmail(email);
                user.setPassword(pass.getText().toString());
                user.setLink(link.getText().toString());
                user.setDescrizione(bio.getText().toString());
                user.setPosizione(posizione.getText().toString());

                service.updateVenditore(user).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                        onBackPressed();

                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                        onBackPressed();

                    }
                });

            }

        });


    }
}
