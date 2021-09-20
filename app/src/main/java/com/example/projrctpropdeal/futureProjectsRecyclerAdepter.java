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

public class futureProjectsRecyclerAdepter extends RecyclerView.Adapter<futureProjectsRecyclerAdepter.MyViewHolder> {

    int[] id;
    int[] images;
    String[] price;
    String[] title;
    String[] distance;
    String[] location;
    String[] bookStartDate;
    Context context;
    futureProjectsRecyclerAdepter(Context ct, int[] id, int[] images, String[] price, String[] title, String[] distance, String[] location ,String[] bookStartDate){
        this.id=id;
        this.images = images;
        this.price = price;
        this.bookStartDate=bookStartDate;
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
        View view=inflater.inflate(R.layout.future_projects_recycler_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull futureProjectsRecyclerAdepter.MyViewHolder holder, int position) {

        holder.image.setImageResource(images[position]);
        holder.pri.setText("₹ "+price[position]);
        holder.bookStartDate.setText("Booking Start on "+bookStartDate[position]);
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
        TextView pri;
        TextView bookStartDate;
        ImageView image;
        TextView ttl;
        TextView dist;
        TextView loc;
        ImageView fav;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image_of_product);
            pri=itemView.findViewById(R.id.price_of_property);
            bookStartDate=itemView.findViewById(R.id.book_start_date);
            ttl=itemView.findViewById(R.id.title_of_property);
            dist=itemView.findViewById(R.id.distance_of_property);
            loc=itemView.findViewById(R.id.location_of_property);
            cardView=itemView.findViewById(R.id.card);
            fav=itemView.findViewById(R.id.favourite_property);

        }
    }
}
