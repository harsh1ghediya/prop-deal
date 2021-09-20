package com.example.projrctpropdeal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


public class fragment_home extends Fragment  {

   //var declaration
    RecyclerView recyclerView;
    ImageView map_location;
    TextView your_loc=null;
    String loc_area=null;
    String loc_city=null;
    String loc_postal=null;
    String full_add=null;
    int[] id={1,2,3};
    int[] images={R.drawable.demo_prop3,R.drawable.demo_prop1,R.drawable.demo_prop2};
    String[] price={"10000000","9000000","20000000"};
    String[] title={"3 bhk bungalow for sell","4 bhk bungalow with garden","3 bhk bungalow at center of city"};
    String[] distance={"600 m","25 km","29 km"};
    String[] location={"Vadodara","Vadodara","Vadodara"};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.recyclerView_home);
        map_location=view.findViewById(R.id.map_location);
        your_loc=view.findViewById(R.id.your_loc);


        //coding



        SharedPreferences sP=this.getActivity().getSharedPreferences("pdPref",MODE_PRIVATE);
        loc_area= sP.getString("area",null);
        loc_city= sP.getString("city",null);
        loc_postal=sP.getString("postal",null);
        full_add=loc_area+","+loc_city+".";

        if(full_add !=null){
            your_loc.setText(full_add);
        }




        homeRecyclerAdepter homerecyclerAdepter= new homeRecyclerAdepter(getContext(),id,images,price,title,distance,location);
        recyclerView.setAdapter(homerecyclerAdepter);
        //linear layout vertically
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        //listeners

        map_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_map;
                intent_map = new Intent(getContext(), getLocationActivity.class);
                startActivity(intent_map);
            }
        });




        return view;




    }



}