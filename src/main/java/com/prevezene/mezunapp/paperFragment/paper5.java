package com.prevezene.mezunapp.paperFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prevezene.mezunapp.R;
import com.prevezene.mezunapp.adapter.RecyclerViewAdapter4;
import com.prevezene.mezunapp.adapter.RecyclerViewAdapter5;
import com.prevezene.mezunapp.paperAPI;
import com.prevezene.mezunapp.paper_model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class paper5 extends AppCompatActivity {
    ArrayList<paper_model> papermodel;
    private String BASE_URL = "https://9b3e9895-5aca-4be5-bf57-eefc2125ef0b.mock.pstmn.io/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    //adapter1 adapter1;
    // CompositeDisposable compositeDisposable;
    RecyclerViewAdapter5 recyclerViewAdapter5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper5);
        recyclerView=findViewById(R.id.recyclerView5);
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        loadData();

    }




    private void loadData() {

        final paperAPI PaperAPI = retrofit.create(paperAPI.class);

/*
        compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(paperAPI.getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse));

        */
        Call<List<paper_model>> call = PaperAPI.getData();
        call.enqueue(new Callback<List<paper_model>>() {
            @Override
            public void onResponse(Call<List<paper_model>> call, Response<List<paper_model>> response) {
                if (response.isSuccessful()) {
                    List<paper_model> responseList5 = response.body();
                    papermodel = new ArrayList<>(responseList5);
                    //RecyclerView
                    recyclerView.setLayoutManager(new LinearLayoutManager(paper5.this));
                    recyclerViewAdapter5 = new RecyclerViewAdapter5(papermodel);
                    recyclerView.setAdapter(recyclerViewAdapter5);

                    for (paper_model Model : papermodel) {

                        System.out.println(Model.paper_five);



                    }
                }
            }
            @Override
            public void onFailure(Call<List<paper_model>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
                    /*
    private void handleResponse(<List<paper_model>> paperModelList) {
        papermodel = new ArrayList<>(paperModelList);

        //RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(paper1.this));
        adapter1  = new adapter1(papermodel);
        recyclerView.setAdapter(adapter1);
    }



}
    @Override
    protected void onDestroy() {
        super.onDestroy();

        compositeDisposable.clear();
    }*/
}