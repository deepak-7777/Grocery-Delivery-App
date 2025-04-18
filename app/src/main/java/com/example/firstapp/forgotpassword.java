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

public class forgotpassword extends AppCompatActivity {
    public void platform (View view) {
        startActivity(new Intent(getApplicationContext(),  LoginActivity.class));
    }
    private EditText etPassword;
    private EditText etconfirmpassword;
    private Button btnnext;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgotpassword);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etPassword = findViewById(R.id.ed_username);
        etconfirmpassword = findViewById(R.id.ed_username3);
        btnnext = findViewById(R.id.button5);
        sharedPreferences = getSharedPreferences("deepak", Context.MODE_PRIVATE);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassword = etPassword.getText().toString().trim();
                String confirmpassword = etconfirmpassword.getText().toString().trim();

                // Check if any field is empty
                if (TextUtils.isEmpty(newPassword) || TextUtils.isEmpty(confirmpassword)) {
                    Toast.makeText(forgotpassword.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if passwords match
                if (!newPassword.equals(confirmpassword)) {
                    Toast.makeText(forgotpassword.this, "Password not matched", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save the password in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("password", newPassword);
                editor.apply();

                // Show success message
                Toast.makeText(forgotpassword.this, "Password Changed Successfully.", Toast.LENGTH_SHORT).show();

                // Start the LoginActivity
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}