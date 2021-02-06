package com.prevezene.mezunapp;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*Navigation menü de mezunlarımıza tıkladığında
fragment_mezunlarimiz.xml yapısının bağlı olduğu fragment*/

public class mezunlarimiz extends Fragment {
    ViewPager viewPager;
    user_adapter adapter;
    TextView txt1, txt2;
    List<user_model> models;

    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private mezunlarimizViewModel mezunlarimizViewModel;




        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;
        private Object mezunlarimiz;


        public mezunlarimiz() {
            // Required empty public constructor
        }


        public static mezunlarimiz newInstance(String param1, String param2) {
            mezunlarimiz fragment = new mezunlarimiz();
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

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mezunlarimizViewModel=
                ViewModelProviders.of(this).get(mezunlarimizViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mezunlarimiz, container, false);
        txt1=root.findViewById(R.id.toolbar_title3);


        models = new ArrayList<>();
        models.add(new user_model(R.drawable.mezun1, "Ali Yaşar", "Senior Software Engineer at Bigg Plus", "Java Developer\n" +
                "Şirket Adı: Vitelco Şirket Konumu: Yavuz Sultan Selim, İstanbul, Türkiye","Java Web Developer\n" +
                "Şirket Adı: Koton Şirket Konumu: İstanbul, Türkiye"));
        models.add(new user_model(R.drawable.mezun2, "Oğuz Oktay Büyük", "akın soft java developer","Veri Platformları Kıdemli Uzmanı\n" +
                "Şirket Adı: KoçSistem Şirket Konumu: Ünalan, İstanbul, Türkiyer","MANAGEMENT TRAİNEE\n" +
                "Şirket Adı: Memorial Healthcare Group Şirket Konumu: Yavuz Sultan Selim, İstanbul, Türkiye"));
        models.add(new user_model(R.drawable.mezun3, "Süleyman Güngörmez", "New York, New York, Birleşik Devletler","KIDEMLİ YAZILIM MÜHENDİSİ\n" +
                "Şirket Adı: Turkcell Şirket Konumu: İstanbul, Türkiye","Senior Java Developer\n" +
                "Şirket Adı: Bilyoner Konumu: Yavuz Sultan Selim, İstanbul, Türkiye"));
        models.add(new user_model(R.drawable.mexun5, "Melih Kerman", "Kafein Technology Solution şirketinde Scrum Master","Android Developer\n" +
                "Şirket Adı: Path - Digital Experiences Şirket Konumu: İstanbul, İstanbul, Türkiye","front end voip developer\n" +
                "Şirket Adı: Turkcell Konumu: İstanbul, Türkiye"));

        //adapter = (Adapter) new user_adapter( models, user_adapter.class);
       // Toast.makeText(getContext(),"hayde" ,  Toast.LENGTH_SHORT).show();
        adapter = new user_adapter(models, getContext());
        viewPager = root.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 150, 130, 0);



        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }
                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }



            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ObjectAnimator animator= ObjectAnimator.ofInt(txt1,"backgroundColor",Color.WHITE,Color.YELLOW,Color.BLUE);
        animator.setDuration(500);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setRepeatMode(Animation.REVERSE);
        animator.setRepeatCount(Animation.INFINITE);
        animator.start();

        return  root;


        // Inflate the layout for this fragment

    }
}