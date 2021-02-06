package com.prevezene.mezunapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/*Navigation menü de haberlere tıkladığında
fragment_fsmvu_paper.xml yapısının bağlı olduğu fragment*/
public class fsmvu_paper extends Fragment  {

    private fsmvu_paperViewModel fsmvu_paperViewModel;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fsmvu_paper() {

    }


    public static fsmvu_paper newInstance(String param1, String param2) {
        fsmvu_paper fragment = new fsmvu_paper();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fsmvu_paperViewModel=
                ViewModelProviders.of(this).get(fsmvu_paperViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fsmvu_paper, container, false);

        // -----------------------HABER 1
        CardView haber1=root.findViewById(R.id.haber1_1);
        haber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haber= new Intent(getContext(), com.prevezene.mezunapp.paperFragment.paper1.class);
              startActivity(haber);

            }
        });

        // -----------------------HABER 2
        CardView haber2=root.findViewById(R.id.haber2_2);
        haber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haber= new Intent(getContext(), com.prevezene.mezunapp.paperFragment.paper2.class);
                startActivity(haber);

            }
        });
        // -----------------------HABER 3
        CardView haber3=root.findViewById(R.id.haber3_3);
        haber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haber= new Intent(getContext(), com.prevezene.mezunapp.paperFragment.paper3.class);
                startActivity(haber);

            }
        });

        // -----------------------HABER 4
        CardView haber4=root.findViewById(R.id.haber4_4);
        haber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haber= new Intent(getContext(), com.prevezene.mezunapp.paperFragment.paper4.class);
                startActivity(haber);

            }
        });// -----------------------HABER 5
        CardView haber5=root.findViewById(R.id.haber5_5);
        haber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haber= new Intent(getContext(), com.prevezene.mezunapp.paperFragment.paper5.class);
                startActivity(haber);

            }
        });
        // -----------------------HABER 6
        CardView haber6=root.findViewById(R.id.haber6_6);
        haber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haber= new Intent(getContext(), com.prevezene.mezunapp.paperFragment.paper6.class);
                startActivity(haber);

            }
        });




        return  root;

    }
}