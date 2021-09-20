package com.example.projrctpropdeal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

public class homeRecyclerAdepter extends RecyclerView.Adapter<homeRecyclerAdepter.MyViewHolder> {

    int[] id;
    int[] images;
    String[] price;
    String[] title;
    String[] distance;
    String[] location;
    Context context;
    homeRecyclerAdepter(Context ct, int[] id, int[] images, String[] price, String[] title, String[] distance, String[] location){
        this.id=id;
        this.images = images;
        this.price = price;
        this.title = title;
        this.distance = distance;
        this.location = location;
        this.context=ct;
    }


    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.home_recycler_layout,parent,false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull homeRecyclerAdepter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.image.setImageResource(images[position]);
        holder.pri.setText("₹ "+price[position]);
        holder.ttl.setText(title[position]);
        holder.dist.setText(distance[position]);
        holder.loc.setText("~ "+location[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_prop=new Intent(context,propertyActivity.class);
                context.startActivities(new Intent[]{intent_prop});

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
        TextView pri;
        ImageView image;
        TextView ttl;
       TextView dist;
        TextView loc;
        ImageView fav;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image_of_product);
            pri=itemView.findViewById(R.id.price_of_property);
            ttl=itemView.findViewById(R.id.title_of_property);
            dist=itemView.findViewById(R.id.distance_of_property);
            loc=itemView.findViewById(R.id.location_of_property);
           cardView=itemView.findViewById(R.id.card);
           fav=itemView.findViewById(R.id.favourite_property);

        }
    }


}
