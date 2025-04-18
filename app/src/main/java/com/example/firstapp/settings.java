package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class settings extends AppCompatActivity {
    // sign out
    public void signoutt (View view) {
        Toast.makeText(this, "Sign out", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),  LoginActivity.class));
    }

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
    }
}