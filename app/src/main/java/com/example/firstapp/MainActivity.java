package com.example.firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    // Grocery & Kitchen   (Image View)
    public void image_msg (View view) {
        startActivity(new Intent(getApplicationContext(),  veg.class));
    }
    public void image_msg1 (View view) {
        startActivity(new Intent(getApplicationContext(),  meat.class));
    }
    public void image_msg2 (View view) {
        startActivity(new Intent(getApplicationContext(),  breakfast.class));
    }
    public void image_msg3 (View view) {
        startActivity(new Intent(getApplicationContext(),  masala.class));
    }
    public void image_msg4 (View view) {
        startActivity(new Intent(getApplicationContext(),  skincare.class));
    }
    public void image_msg5 (View view) {
        startActivity(new Intent(getApplicationContext(),  feminine.class));
    }
    public void image_msg6 (View view) {
        startActivity(new Intent(getApplicationContext(),  jewellery.class));
    }
    public void image_msg7 (View view) {
        startActivity(new Intent(getApplicationContext(),  babycare.class));
    }
    public void image_msg8 (View view) {
        startActivity(new Intent(getApplicationContext(),  kitchen.class));
    }
    public void image_msg9 (View view) {
        startActivity(new Intent(getApplicationContext(),  electronics.class));
    }
    public void image_msg10 (View view) {
        startActivity(new Intent(getApplicationContext(),  toys.class));
    }
    public void image_msg11 (View view) {
        startActivity(new Intent(getApplicationContext(),  stationery.class));
    }
    public void image_msg12 (View view) {
        startActivity(new Intent(getApplicationContext(),  icecream.class));
    }
    public void image_msg13 (View view) {
        startActivity(new Intent(getApplicationContext(),  frozen.class));
    }
    public void image_msg14 (View view) {
        startActivity(new Intent(getApplicationContext(),  biscuits.class));
    }
    public void image_msg15 (View view) {
        startActivity(new Intent(getApplicationContext(),  colddrinks.class));
    }



    // Grocery & Kitchen   (Text View)
    public void text_msg (View view) {
        startActivity(new Intent(getApplicationContext(),  veg.class));
    }
    public void text_msg1 (View view) {
        startActivity(new Intent(getApplicationContext(),  meat.class));
    }
    public void text_msg2 (View view) {
        startActivity(new Intent(getApplicationContext(),  breakfast.class));
    }
    public void text_msg3 (View view) {
        startActivity(new Intent(getApplicationContext(),  masala.class));
    }
    public void text_msg4 (View view) {
        startActivity(new Intent(getApplicationContext(),  skincare.class));
    }
    public void text_msg5 (View view) {
        startActivity(new Intent(getApplicationContext(),  feminine.class));
    }
    public void text_msg6 (View view) {
        startActivity(new Intent(getApplicationContext(),  jewellery.class));
    }
    public void text_msg7 (View view) {
        startActivity(new Intent(getApplicationContext(),  babycare.class));
    }
    public void text_msg8 (View view) {
        startActivity(new Intent(getApplicationContext(),  kitchen.class));
    }
    public void text_msg9 (View view) {
        startActivity(new Intent(getApplicationContext(),  electronics.class));
    }
    public void text_msg10 (View view) {
        startActivity(new Intent(getApplicationContext(),  toys.class));
    }
    public void text_msg11 (View view) {
        startActivity(new Intent(getApplicationContext(),  stationery.class));
    }
    public void text_msg12 (View view) {
        startActivity(new Intent(getApplicationContext(),  icecream.class));
    }
    public void text_msg13 (View view) {
        startActivity(new Intent(getApplicationContext(),  frozen.class));
    }
    public void text_msg14 (View view) {
        startActivity(new Intent(getApplicationContext(),  biscuits.class));
    }
    public void text_msg15 (View view) {
        startActivity(new Intent(getApplicationContext(),  colddrinks.class));
    }



    //  Menu Item
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.action_settings){
            startActivity(new Intent(getApplicationContext(),  settings.class));
        }
        if(itemId == R.id.action_profile){
            startActivity(new Intent(getApplicationContext(),  profile.class));
        }
        return super.onOptionsItemSelected(item);
    }


    private AppBarConfiguration mAppBarConfiguration;   //   part of MainActivity
    private ActivityMainBinding binding;            //   part of MainActivity


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.toolbar).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_menu,  R.id.nav_cart, R.id.nav_ongoing, R.id.nav_history, R.id.nav_rewards,
                R.id.nav_feedback, R.id.nav_terms, R.id.nav_contact, R.id.nav_share)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}