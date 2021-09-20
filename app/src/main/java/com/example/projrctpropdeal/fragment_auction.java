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


public class fragment_auction extends Fragment {

    RecyclerView recyclerView;
    TextView your_loc=null;
    String loc_area=null;
    String loc_city=null;
    String loc_postal=null;
    String full_add=null;
    int[] id={1,2,3};
    int[] images={R.drawable.demo_prop2,R.drawable.demo_prop1,R.drawable.demo_prop3};
    String[] price={"9000000","10000000","20000000"};
    String[] title={"4 bhk bungalow with garden","3 bhk bungalow for sell","3 bhk bungalow at center of city"};
    String[] distance={"600 m","29 km","25 km"};
    String[] location={"Vadodara","Vadodara","Vadodara"};
    String[] startDate={"22/08/21","24/08/21","30/08/21"};
    String[] startTime={"12:00","10:30","11:20"};
    String[] endDate={"24/08/21","25/08/21","2/09/21"};
    String[] endTime={"12:00","12:00","11:20"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_auction, container, false);



        recyclerView=view.findViewById(R.id.recyclerView_auction);
        your_loc=view.findViewById(R.id.your_loc);


        //coding
        SharedPreferences sP=this.getActivity().getSharedPreferences("pdPref",MODE_PRIVATE);
        loc_area= sP.getString("area",null);
        loc_city= sP.getString("city",null);
        loc_postal=sP.getString("postal",null);
        full_add=loc_area+","+loc_city+".";

        your_loc.setText(full_add);


        auctionRecyclerAdepter auctionrecyclerAdepter= new auctionRecyclerAdepter(getContext(),id,images,price,title,distance,location,startDate,startTime,endDate,endTime);
        recyclerView.setAdapter(auctionrecyclerAdepter);
        //linear layout vertically
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}