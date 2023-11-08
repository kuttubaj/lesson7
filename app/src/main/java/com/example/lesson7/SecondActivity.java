package com.example.lesson7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private Button btnnazad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnnazad = findViewById(R.id.knopka_nazad);
        setupListeners();
    }

    private void setupListeners() {
        btnnazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoBack = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intentGoBack);
            }
        });
    }
}