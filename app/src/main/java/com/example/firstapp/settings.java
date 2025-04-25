package com.example.firstapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class settings extends AppCompatActivity {

     // back button
    public void back_button17 (View view) {
        startActivity(new Intent(getApplicationContext(),  MainActivity.class));
    }

    // All Item
    public void account (View view) {
        Toast.makeText(this, "Clicked Account", Toast.LENGTH_SHORT).show();
    }
    public void privacy (View view) {
        Toast.makeText(this, "Clicked Privacy", Toast.LENGTH_SHORT).show();
    }
    public void notification (View view) {
        Toast.makeText(this, "Clicked Notification", Toast.LENGTH_SHORT).show();
    }
    public void language (View view) {
        Toast.makeText(this, "Clicked App Language", Toast.LENGTH_SHORT).show();
    }
    public void help (View view) {
        Toast.makeText(this, "Clicked Help", Toast.LENGTH_SHORT).show();
    }
    public void update (View view) {
        Toast.makeText(this, "Clicked App Update", Toast.LENGTH_SHORT).show();
    }
    public void storage (View view) {
        Toast.makeText(this, "Clicked Storage and Data", Toast.LENGTH_SHORT).show();
    }




    private Button btnLogout;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnLogout = findViewById(R.id.btn_logout); // Your logout button ID
        sharedPreferences = getSharedPreferences("deepak", Context.MODE_PRIVATE);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear SharedPreferences data
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                // Go back to login screen
                Intent intent = new Intent(settings.this, welcome.class);
                Toast.makeText(settings.this, "LogOut Here", Toast.LENGTH_SHORT).show();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear activity stack
                startActivity(intent);
                finish();
            }
        });

    }
}