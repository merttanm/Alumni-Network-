package com.prevezene.mezunapp.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.prevezene.mezunapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
/*
 Uygulamada kullanmış olduğum fotoğrafları dinamikleştirmek için
 Picasso kütüphanesini kullanıyorum. Picasso fotoğrafları lokalde
 kullanırken onlara özel kullanabileceğim bir kütüphane. Bu özel
 kütüphanenin işlevi işe Http formatında bir yoldan çekerek devam
 eder. */
public class GalleryFragment extends Fragment {
    ViewFlipper kayır;
    private GalleryViewModel galleryViewModel;
    ImageView img,img2,img3,img4;
    String url ="https://www.fsm.edu.tr/resimler/upload/meryem-betul-kocak2019-12-24-04-26-49pm.jpg";
    String url_2="https://www.fsm.edu.tr/resimler/upload/esra-battal-mimarlik2019-11-28-12-42-36pm.jpg";
    String url_3="https://www.fsm.edu.tr/resimler/upload/merve-yildiz2019-11-28-12-42-36pm.jpg";
    String url_4="https://www.fsm.edu.tr/resimler/upload/sevval-sevimli2019-11-28-12-42-37pm.jpg";
    @SuppressLint("WrongViewCast")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        return root;
    }
    public void flipper(String image){
        ImageView imageView= new ImageView(getContext());
        imageView.setBackgroundResource(Integer.parseInt(image));

        kayır.addView(imageView);
        kayır.setFlipInterval(500);
        kayır.setAutoStart(true);

        kayır.setInAnimation(getContext(),android.R.anim.fade_in);
        kayır.setOutAnimation(getContext(),android.R.anim.fade_out);


    }


    private void resimyükle(String url) {

        Picasso.get()
                .load(url)
                .error(R.mipmap.ic_launcher)
                .into(img, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }

                });
    }
    private void resimyükle2(String url_2) {

        Picasso.get()
                .load(url_2)
                .error(R.mipmap.ic_launcher)
                .into(img2, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }

                });
    }
    private void resimyükle3(String url_3) {

        Picasso.get()
                .load(url_3)
                .error(R.mipmap.ic_launcher)
                .into(img3, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }

                });
    }
    private void resimyükle4(String url_4) {

        Picasso.get()
                .load(url_4)
                .error(R.mipmap.ic_launcher)
                .into(img4, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }

                });
    }

}