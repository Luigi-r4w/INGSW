package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.dietideals24.R;
import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.NewUser;
import com.example.dietideals24.Connection.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private ApiService service;

    public void onBackPressed() {
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.signup_scene);
        String tipo = getIntent().getSerializableExtra("tipo").toString();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("  Sign Up");
        EditText nome = findViewById(R.id.editTextNome);
        EditText email = findViewById(R.id.editTextEmail);
        EditText pass = findViewById(R.id.editTextPassword);


        findViewById(R.id.button2).setOnClickListener(view -> {
            if (nome.getText().toString().isEmpty() | email.getText().toString().isEmpty() | pass.getText().toString().isEmpty()){
                Toast.makeText(SignUpActivity.this, "Ci sono dei campi vuoti", Toast.LENGTH_SHORT).show();
            } else {
                NewUser user = new NewUser(nome.getText().toString(), email.getText().toString(), pass.getText().toString(), tipo);
                service = Service.initialize().create(ApiService.class);
                service.newUser(user).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.body().booleanValue()){
                            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                            intent.putExtra("email", email.getText().toString());
                            intent.putExtra("tipo", tipo);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }


}
