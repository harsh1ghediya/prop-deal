package com.example.projrctpropdeal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class homeActivity extends AppCompatActivity {

    //variable declaration
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //memory allocation
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        materialToolbar=findViewById(R.id.topAppbar);


        //Initialize Bottom Navigation View.
        BottomNavigationView navView = findViewById(R.id.bottomNav_view);

        //coding
        getSupportActionBar().hide();






        //Pass the ID's of Different destinations for bottom nav
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.id_fragment_home, R.id.id_fragment_auction, R.id.id_fragment_future_projects,R.id.id_fragment_roi,R.id.id_fragment_sell)
                .build();


        //Initialize NavController. for bottom nav
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        //listeners
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

                int id=item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id){
                    case R.id.profile:
                        Toast.makeText(homeActivity.this, "clicked on profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.notification:
                        Toast.makeText(homeActivity.this, "clicked on notification", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.chat:
                        Toast.makeText(homeActivity.this, "clicked on chat", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.aboutus:

                        Intent intent_about_us=new Intent(homeActivity.this,aboutUsActivity.class);
                        startActivity(intent_about_us);

                        break;
                    case R.id.contactus:
                        Toast.makeText(homeActivity.this, "clicked on conatactus", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.report:
                        Toast.makeText(homeActivity.this, "clicked on report", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        SharedPreferences sP=getSharedPreferences("pdPref",MODE_PRIVATE);
                        SharedPreferences.Editor ed=sP.edit();
                        ed.putString("email",null);
                        ed.putString("password",null);
                        ed.apply();
                        Intent intent=new Intent(homeActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

    }
}