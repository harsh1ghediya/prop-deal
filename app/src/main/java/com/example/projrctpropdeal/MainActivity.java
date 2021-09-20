package com.example.projrctpropdeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    //variable declaration
    String eml,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); //to hide actionbar in splash screen

        //Handler for Splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sP=getSharedPreferences("pdPref",MODE_PRIVATE);
                 eml= sP.getString("email",null);
                 if(eml==null){
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                    {
                    Intent intent = new Intent(MainActivity.this, homeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },1500);

    }
}