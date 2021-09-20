package com.example.projrctpropdeal;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class fragment_sell extends Fragment {

    TextView sell_date;
    int d,m,y;
    String dt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sell, container, false);

        sell_date=view.findViewById(R.id.sell_date);
        Calendar calendar=Calendar.getInstance();


        sell_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=calendar.get(Calendar.DAY_OF_MONTH);
                m=calendar.get(Calendar.MONTH);
                y=calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        d=dayOfMonth;
                        m=month;
                        y=year;
                        dt=d+"/"+m+"/"+y;
                        sell_date.setText(dt);
                    }
                },y,m,d);
                datePickerDialog.show();
            }
        });



        return view;
    }
}