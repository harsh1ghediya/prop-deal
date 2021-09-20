package com.example.projrctpropdeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    //variable definition
    EditText email,password;
    Button login;
    TextView signup;
    String eml,pass;
    TextView forgot;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //variable allocation
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        forgot=findViewById(R.id.forgot);
        constraintLayout=findViewById(R.id.login_constraint_layout);

        //codding


        getSupportActionBar().hide();
        //Listeners


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eml=email.getText().toString();
                pass=password.getText().toString();

                if(eml.equals("@harsh") && pass.equals("1234"))
                {
                    SharedPreferences sP=getSharedPreferences("pdPref",MODE_PRIVATE);
                    SharedPreferences.Editor ed=sP.edit();
                    ed.putString("email",eml);
                    ed.putString("password",pass);
                    ed.apply();
                    Intent intent=new Intent(LoginActivity.this, homeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Snackbar snackbar = Snackbar.make(constraintLayout, "Please Enter Right Email and Password", Snackbar.LENGTH_LONG);
                    View view = snackbar.getView();
                    FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
                    params.gravity = Gravity.TOP;
                    view.setLayoutParams(params);
                    view.setBackgroundColor(Color.RED);
                    snackbar.show();
                   email.setText("");
                   password.setText("");
                }

            }
        });//While click on login button


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(LoginActivity.this,signupActivity.class);
                startActivity(intent1);
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(LoginActivity.this, "clicked on forgot password", Toast.LENGTH_SHORT).show();

            }
        });



    }
}