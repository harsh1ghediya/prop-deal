package com.example.projrctpropdeal;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class getLocationActivity extends AppCompatActivity {


    TextView getCurrLoc;
    String area;
    String cityName = null;
    String state=null;
    String postal=null;
    Location loc = null;
    double longitude;
    double latitude;
    Button ok_loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location_actovity);

        getCurrLoc=findViewById(R.id.id_current_loc);
        ok_loc=findViewById(R.id.ok_loc);


        getCurrLoc.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[] {Manifest.permission.ACCESS_COARSE_LOCATION },1000);
                }
                else{
                    LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                    Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
                    List<Address> address;
                    latitude=location.getLatitude();
                    longitude=location.getLongitude();

                    try {
                        address=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

                        if(address.size() >0){
                            if(address.get(0).getLocality()!=null && address.get(0).getLocality().length()>0){

                                area=address.get(0).getSubLocality();
                                cityName=address.get(0).getLocality();
                                state=address.get(0).getAdminArea();
                                postal=address.get(0).getPostalCode();
                            }
                        }

                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                getCurrLoc.setText(area+","+cityName+","+state+","+postal);
            }

        });

        ok_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sP=getSharedPreferences("pdPref",MODE_PRIVATE);
                SharedPreferences.Editor ed=sP.edit();
                ed.putString("area",area);
                ed.putString("city",cityName);
                ed.putString("postal",postal);
                ed.apply();

                Intent intent_loc =new Intent(getLocationActivity.this,homeActivity.class);
                startActivity(intent_loc);
            }
        });
    }
}