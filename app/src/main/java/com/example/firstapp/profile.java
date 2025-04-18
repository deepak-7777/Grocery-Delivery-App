package com.example.firstapp;

import android.annotation.SuppressLint;
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

public class profile extends AppCompatActivity {

    private EditText etmobile;
    private EditText etemail;

    public void back_button18 (View view) {
        startActivity(new Intent(getApplicationContext(),  MainActivity.class));
    }

    public void submit (View view) {

        String newmobile = etmobile.getText().toString().trim();
        String newemail = etemail.getText().toString().trim();

       //  Check if any field is empty
        if (TextUtils.isEmpty(newmobile)) {
                    Toast.makeText(profile.this, "Please enter number", Toast.LENGTH_SHORT).show();
                    return;
                }
        if (TextUtils.isEmpty(newemail)) {
            Toast.makeText(profile.this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Your profile has been submited", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),  MainActivity.class));
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etmobile = findViewById(R.id.mobile);
        etemail = findViewById(R.id.email);

    }
}