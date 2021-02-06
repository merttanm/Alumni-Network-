package com.prevezene.mezunapp;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
/*
Servis oluşturuyorum.
Servis işlemlerinde “GET”, “POST”, “UPDATE”
işlemleri arasında ben “GET” işlemi yapacağım
için buna uygun şekilde dizayn ediyorum.
*/
public interface paperAPI {
/*
Base URL çıkarıldıktan sonra kalan kısmı yazıyorum.
”GET” işlemini yaptıktan sonra bu “GET” işlemini
hangi metot ile yapacağımızı söylüyoruz bunu da Call
oluşturarak yapıyorum. Bu Call bana asekronize bir
şekilde ne indireceğini ve hangi metot içinde
indireceğini söylüyorum bunu da bir liste içinde yapıyorum. */
    @GET("merttanm")
    Call <List<paper_model>>getData();

}
