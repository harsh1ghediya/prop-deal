package com.example.projrctpropdeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {

    //variable declaration
    Button continue1;
    TextView goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //var allocation
        continue1= findViewById(R.id.signup_continue);
        goBack=findViewById(R.id.signup_back);

        //programming
        getSupportActionBar().hide();


        //listeners
        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(signupActivity.this, "clicked on continue", Toast.LENGTH_SHORT).show();
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signupActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}