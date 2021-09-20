package com.example.projrctpropdeal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class auctionRecyclerAdepter extends RecyclerView.Adapter<auctionRecyclerAdepter.MyViewHolder> {

    int[] id;
    int[] images;
    String[] price;
    String[] title;
    String[] distance;
    String[] location;
    String[] startDate;
    String[] startTime;
    String[] endDate;
    String[] endTime;
    Context context;
    auctionRecyclerAdepter(Context ct, int[] id, int[] images, String[] price, String[] title, String[] distance, String[] location,String[] startDate,String[] startTime,String[] endDate,String[] endTime){
        this.id=id;
        this.images = images;
        this.price = price;
        this.title = title;
        this.distance = distance;
        this.location = location;
        this.context=ct;
        this.startDate=startDate;
        this.startTime=startTime;
        this.endDate=endDate;
        this.endTime=endTime;
    }


    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.auction_recycler_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull auctionRecyclerAdepter.MyViewHolder holder, int position) {

        holder.image.setImageResource(images[position]);
        holder.starsDT.setText("Start: "+startDate[position]+"  Time: "+startTime[position]);
        holder.endDT.setText("End: "+endDate[position]+"  Time: "+endTime[position]);
        holder.ttl.setText(title[position]);
        holder.dist.setText(distance[position]);
        holder.loc.setText("~ "+location[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,"you clicked on id:" + id[position], Toast.LENGTH_SHORT).show();
            }
        });
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you liked id:"+ id[position], Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return id.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView starsDT;
        TextView endDT;
        ImageView image;
        TextView ttl;
        TextView dist;
        TextView loc;
        ImageView fav;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image_of_product);
            starsDT=itemView.findViewById(R.id.start_datetime);
            endDT=itemView.findViewById(R.id.end_datetime);
            ttl=itemView.findViewById(R.id.title_of_property);
            dist=itemView.findViewById(R.id.distance_of_property);
            loc=itemView.findViewById(R.id.location_of_property);
            cardView=itemView.findViewById(R.id.card);
            fav=itemView.findViewById(R.id.favourite_property);

        }
    }
}

