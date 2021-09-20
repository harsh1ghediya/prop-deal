package com.example.projrctpropdeal;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

public class fragment_future_projects extends Fragment {

    RecyclerView recyclerView;
    TextView your_loc=null;
    String loc_area=null;
    String loc_city=null;
    String loc_postal=null;
    String full_add=null;
    int[] id={1,2,3};
    int[] images={R.drawable.demo_prop1,R.drawable.demo_prop2,R.drawable.demo_prop3};
    String[] price={"9000000","9600000","10000000"};
    String[] title={"3 bhk bungalow for sell","4 bhk bungalow with garden","3 bhk bungalow at center of city"};
    String[] distance={"600 m","25 km","29 km"};
    String[] location={"Vadodara","Vadodara","Vadodara"};
    String[] bookStartDate={"22/09/21","10/12/21","04/01/22"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_future_projects, container, false);

        recyclerView=view.findViewById(R.id.recyclerView_future_project);
        your_loc=view.findViewById(R.id.your_loc);


        //coding
        SharedPreferences sP=this.getActivity().getSharedPreferences("pdPref",MODE_PRIVATE);
        loc_area= sP.getString("area","n");
        loc_city= sP.getString("city","n");
        full_add=loc_area+","+loc_city+".";

        if(full_add =="n,n."){
            your_loc.setText("your loc...");
        }
        else {
            your_loc.setText(full_add);
        }


        futureProjectsRecyclerAdepter futureProjectsRecyclerAdepter= new futureProjectsRecyclerAdepter(getContext(),id,images,price,title,distance,location,bookStartDate);
        recyclerView.setAdapter(futureProjectsRecyclerAdepter);
        //linear layout vertically
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}