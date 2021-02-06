package com.prevezene.mezunapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.Toast;
import com.prevezene.mezunapp.paperAPI;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prevezene.mezunapp.ui.gallery.GalleryViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.OkHttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;
import static okhttp3.OkHttpClient.*;


/*
Giriş yaptıktan sonra ana sayfada ScrollView yapısı kullandım
DUYURULAR, KAMPUSÜMÜZDEN, BİZE ULAŞIN katagorileri
karşılıyor ve ek olarak GridLayout tasarımı ile Facebook,
Twitter, İnstegram, uzem , kütüphane kutularına tıkladığı an
ilgili sayfalarına doğrudan yönlendirebiliyoruz
*/

public class mezunPlatformu_Fragment extends Fragment  {
    ArrayList<paper_model> papermodel;
    private String BASE_URL = "https://d1e5c441-74c9-43fc-8fec-7ee4e2a5f067.mock.pstmn.io/";
     Retrofit retrofit;
    ViewFlipper kayır;
    private mezunPlatformuViewModel mezunPlatformuViewModel;

    CompositeDisposable compositeDisposable;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        mezunPlatformuViewModel=
                ViewModelProviders.of(this).get(mezunPlatformuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_blank, container, false);


        int images[]={R.drawable.duyuru1,R.drawable.ekle2,R.drawable.ekle3,R.drawable.ekle1,R.drawable.duyuru2};
        kayır= root.findViewById(R.id.dfdf);

        for (int image:images){

            flipper(image);
        }
/*
        //Retrofit & JSON
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
       // loadData();

*/

        CardView lyt1=root.findViewById(R.id.twitter);
        lyt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://twitter.com/fsmvu"));
                startActivity(intent);

            }
        });
        CardView lyt2=root.findViewById(R.id.instegram);
        lyt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/fsmvuniv/?hl=tr"));
                startActivity(intent);

            }
        });
        CardView lyt3=root.findViewById(R.id.obs);
        lyt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://obs.fsm.edu.tr/oibs/ogrenci/login.aspx"));
                startActivity(intent);

            }
        });
        CardView lyt4=root.findViewById(R.id.ogrenciisleri);
        lyt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://ogrenci.fsm.edu.tr/"));
                startActivity(intent);

            }
        });

        CardView lyt5=root.findViewById(R.id.yemek);
        lyt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://sks.fsm.edu.tr/Saglik-Kultur-ve-Spor-D-Baskanligi-Beslenme-Hiz--Kantin-ve-Yemekhaneler"));
                startActivity(intent);

            }
        });
        /*
        CardView lyt6=root.findViewById(R.id.uzem);
        lyt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://uzem.fsm.edu.tr/"));
                startActivity(intent);

            }
        });
*/
        TextView haber1=root.findViewById(R.id.haber1);
        haber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse("https://www.facebook.com/groups/126933410750484"));
               startActivity(intent);
            }
        });
        TextView haber2=root.findViewById(R.id.haber2);
        haber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/groups/126933410750484"));
                startActivity(intent);
            }
        });

        TextView haber3=root.findViewById(R.id.haber3);
        haber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/groups/126933410750484"));
                startActivity(intent);
            }
        });


        return  root;





    }



    public void flipper(int image){
        ImageView imageView= new ImageView(getContext());
        imageView.setBackgroundResource(image);

        kayır.addView(imageView);
        kayır.setFlipInterval(2000);
        kayır.setAutoStart(true);

        kayır.setInAnimation(getContext(),android.R.anim.slide_in_left);
        kayır.setOutAnimation(getContext(),android.R.anim.slide_out_right);


    }


/*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrofit ve json
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        loaddata();
    }
*/
/*
    public void loadJSON() {




            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();

             paperAPI  paperAPI = retrofit.create(com.prevezene.mezunapp.paperAPI.class);
             Call<List<paper_model>> call= paperAPI.getData();
            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.show();
        call.enqueue(new Callback<List<paper_model>>() {
                @Override
                public void onResponse(Call<List<paper_model>> call, Response<List<paper_model>> response) {
                    if (response.isSuccessful()){
                        List<paper_model> responslist=response.body();
                        papermodel= new ArrayList<>(responslist);


                    }
                }

            @Override
            public void onFailure(Call<List<paper_model>> call, Throwable t) {

            }


            });
        }


*/
/*

   if (response.isSuccessful()){
        List<paper_model> responslist=response.body();
        papermodel= new ArrayList<>(responslist);

        for (paper_model Paper_model : papermodel){
            System.out.println(Paper_model.currency);


        }
        //  Log.i("TAG","ERROR: "+ response.code());
    }



*//*
////////////////////////             ÇALIŞAN KOD
private void loadData() {

    final paperAPI cryptoAPI = retrofit.create(paperAPI.class);

    Call<List<paper_model>> call = cryptoAPI.getData();
    call.enqueue(new Callback<List<paper_model>>() {
        @Override
        public void onResponse(Call<List<paper_model>> call, Response<List<paper_model>> response) {
            if (response.isSuccessful()) {
                List<paper_model> responseList = response.body();
                papermodel = new ArrayList<>(responseList);
                //RecyclerView
                for (paper_model cryptoModel : papermodel) {
                    System.out.println(cryptoModel.currency);
                    System.out.println(cryptoModel.price);
                }
            }
        }
        @Override
        public void onFailure(Call<List<paper_model>> call, Throwable t) {
            t.printStackTrace();
        }
    });
}

*/


/*
    private void loaddata (){

        paperAPI  paperAPI =retrofit.create(com.prevezene.mezunapp.paperAPI.class);
        Call<List<paper_model>> call= paperAPI.getData();
        call.enqueue(new Callback<List<paper_model>>() {
            @Override
            public void onResponse(Call<List<paper_model>> call, Response<List<paper_model>> response) {
                if (response.isSuccessful()){
                    List<paper_model> responslist=response.body();
                    papermodel= new ArrayList<>(responslist);

                    for (paper_model paper_model : papermodel){

                        System.out.println(paper_model.currency);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<paper_model>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
*/
}