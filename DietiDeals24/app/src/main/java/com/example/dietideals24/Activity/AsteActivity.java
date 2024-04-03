package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dietideals24.R;

public class AsteActivity  extends AppCompatActivity {

    public void onBackPressed() {
        Intent intent = new Intent(AsteActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.lista_aste_scene);
    }
}
