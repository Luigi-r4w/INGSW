package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dietideals24.R;

public class NotificheActivity extends AppCompatActivity {

    public void onBackPressed() {
        Intent intent = new Intent(NotificheActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.notifiche_scene);
    }
}