package com.example.lesson7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private Map<String, String> SignInInfo = new HashMap<>();
    private EditText editName;
    private EditText editPassword;
    private Button btn;

    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignInInfo.put("admin123", "admin@gmail.com");
        editName = findViewById(R.id.pochta);
        editPassword = findViewById(R.id.parol);
        btn = findViewById(R.id.knopkaVoiti);
        signIn();
    }

    private void signIn() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etUsername = editName.getText().toString().trim();
                String etPassword = editPassword.getText().toString().trim();
                if (etPassword.isEmpty() || etUsername.isEmpty()) {
                    if (etPassword.isEmpty()) {
                        editPassword.setError("не заполнено");
                    } else if (etUsername.isEmpty()) {
                        editName.setError("не заполнено");
                    } else {
                        editPassword.setError("не заполнено");
                        editName.setError("не заполнено");
                    }

                } else if (SignInInfo.containsKey(etPassword) && SignInInfo.containsValue(etUsername)) {
                    goToSignUp();
                    Toast.makeText(MainActivity.this, "Вход выполнен успешно!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Неверный email или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void goToSignUp() {
        Intent signUpIntent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(signUpIntent);
    }
}

