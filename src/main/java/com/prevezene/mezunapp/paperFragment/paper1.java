package com.prevezene.mezunapp.paperFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prevezene.mezunapp.R;
import com.prevezene.mezunapp.adapter.RecyclerViewAdapter1;
import com.prevezene.mezunapp.paperAPI;
import com.prevezene.mezunapp.paper_model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 Uygulamamda tasarlamış olduğum Üniversitemizden haberler sayfasının
 dinamik yapmaya karar verdim bunu da Retrofitle yapacağım Retrofit,
 benim Http isteklerini ve cevaplarını almamı kolaylaştıran bir kütüphanedir.
 Bu işlemlere başlarken ilk olarak Kütüphane ekliyorum. Retrofit kütüphanesi
 eklerken Conveter-gson kütüphanesini de eklemeyi unutmuyorum çünkü bu
 Converter-gson kütüphanesi JSON objelerinin dönüştürüleceğini yada string,
 integer dönüşümlerini otomatik parse etmek için kullanacağım bir converter.
 Son olarak da Rxjava kütüphanesini de ekledikten sonra kod bloğuna geçiyorum.
  */

public class paper1 extends AppCompatActivity {

    /*
    Paper1 sınıfını oluşturarak bütün işlemeleri içinde oluşturmaya başlıyorum.
    Bu işlemlere bir Model, BASE URL VE Retrofitin kendisini oluşturarak başlıyorum.
    */
    ArrayList<paper_model> papermodel;
    private String BASE_URL = "https://9b3e9895-5aca-4be5-bf57-eefc2125ef0b.mock.pstmn.io/";
    Retrofit retrofit;
    TextView text;
    RecyclerView recyclerView;
    //adapter1 adapter1;
   // CompositeDisposable compositeDisposable;
   RecyclerViewAdapter1 recyclerViewAdapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper1);
        recyclerView=findViewById(R.id.recyclerView);
        Gson gson = new GsonBuilder().setLenient().create();
        text = findViewById(R.id.text2);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        loadData();

    }
/*
Bir model çekeceğimi bildirdim, bu modelin nereden çekileceğini söyledim
ve Gson formatında geleceğini belirttim. Bu yaptığım işlemler datayı alma
için yeterli olmaktadır. Datanın kendisini de oluşturmuş olduğum loadData
da gerçekleştiriyorum. Bütün veriyi loadDatanın içinde çekiyorum.
 */
    private void loadData() {

        final paperAPI paperAPI = retrofit.create(paperAPI.class);

        Call<List<paper_model>> call = paperAPI.getData();
        call.enqueue(new Callback<List<paper_model>>() {
            @Override
            public void onResponse(Call<List<paper_model>> call, Response<List<paper_model>> response) {
                if (response.isSuccessful()) {
                    List<paper_model> responseList = response.body();
                    papermodel = new ArrayList<>(responseList);
                    //RecyclerView
                    recyclerView.setLayoutManager(new LinearLayoutManager(paper1.this));
                    recyclerViewAdapter1 = new RecyclerViewAdapter1(papermodel);
                    recyclerView.setAdapter(recyclerViewAdapter1);


                    for (paper_model Model : papermodel) {

                        System.out.println(Model.paper_one);


                    }
                }
            }
            @Override
            public void onFailure(Call<List<paper_model>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private void handleResponse(List<paper_model> paperModelList) {
        papermodel = new ArrayList<>(paperModelList);

        //RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(paper1.this));
        recyclerViewAdapter1 = new RecyclerViewAdapter1( papermodel );
        recyclerView.setAdapter(recyclerViewAdapter1);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}