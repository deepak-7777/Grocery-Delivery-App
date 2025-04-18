package com.example.firstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    public void nextpage (View view) {
        startActivity(new Intent(getApplicationContext(),  forgotpassword.class));
    }
    public void back_buttonlogin(View view) {
        startActivity(new Intent(getApplicationContext(),  welcome.class));
    }
    private EditText etUsername, etPassword;
    private Button btnLogin, btnsignupp;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUsername = findViewById(R.id.ed_username);
        etPassword = findViewById(R.id.ed_password);
        btnLogin = findViewById(R.id.btn_login);
        btnsignupp = findViewById(R.id.btn_signup);
        sharedPreferences = getSharedPreferences("deepak", Context.MODE_PRIVATE);
        btnLogin.setOnClickListener(view -> loginUser());
    }

    private void loginUser() {
        String enteredUsername = etUsername.getText().toString().trim();
        String enteredPassword = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(enteredUsername) || TextUtils.isEmpty(enteredPassword)) {
            Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        String storedUsername = sharedPreferences.getString("username", null);
        String storedPassword = sharedPreferences.getString("password", null);

        if (storedUsername != null && storedPassword != null) {
            if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),  MainActivity.class));
            } else {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "User not registered", Toast.LENGTH_SHORT).show();
        }
    }
}
