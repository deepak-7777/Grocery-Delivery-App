package com.example.firstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {



//    RadioGroup genderGroup;
//    RadioButton male, female;


    public void back_button19 (View view) {
        startActivity(new Intent(getApplicationContext(),  welcome.class));
    }
    private EditText etUsername;
    private EditText etPassword;
    private EditText etconfirmpassword;
    private Button btnCreateUser;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


//        genderGroup = findViewById(R.id.radiogroup);
//        male = findViewById(R.id.radioButton3);
//        female = findViewById(R.id.radioButton4);
//
//        genderGroup.setOnCheckedChangeListener((group, checkedId) -> {
//            switch (checkedId) {
//                case male:
//                    Toast.makeText(this, "Male selected", Toast.LENGTH_SHORT).show();
//                    break;
//                case female:
//                    Toast.makeText(this, "Female selected", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//   });






        etUsername = findViewById(R.id.editTextText);
        etPassword = findViewById(R.id.editTextText2);
        etconfirmpassword = findViewById(R.id.editTextText5);
        btnCreateUser = findViewById(R.id.button3);
        sharedPreferences = getSharedPreferences("deepak", Context.MODE_PRIVATE);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUsername = etUsername.getText().toString().trim();
                String newPassword = etPassword.getText().toString().trim();
                String confirmpassword = etconfirmpassword.getText().toString().trim();

                // Check if any field is empty
                if (TextUtils.isEmpty(newUsername) || TextUtils.isEmpty(newPassword) || TextUtils.isEmpty(confirmpassword)) {
                    Toast.makeText(SignUpActivity.this, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if passwords match
                if (!newPassword.equals(confirmpassword)) {
                    Toast.makeText(SignUpActivity.this, "Password not matched", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save the username and password in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", newUsername);
                editor.putString("password", newPassword);
                editor.apply();

                // Show success message
                Toast.makeText(SignUpActivity.this, "Registration Successful. You can now login.", Toast.LENGTH_SHORT).show();

                // Start the LoginActivity
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}

