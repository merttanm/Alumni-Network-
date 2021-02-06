package com.prevezene.mezunapp.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.prevezene.mezunapp.R;

import java.util.ArrayList;

/*Navigation menü de iletişime tıkladığında
fragment_slideshow.xml yapısının bağlı olduğu fragment*/

public class SlideshowFragment extends Fragment {
    Button buton_arama1, buton_arama2, buton_arama3, buton_arama4, buton_arama5, buton_arama6, buton_arama7;
    Button mail1, mail2, mail3, mail4, mail5, mail6, mail7;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        
        slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        mail1 =(Button) root.findViewById(R.id.btn_rektorluk2);
        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent i = new Intent(Intent.EXTRA_EMAIL);
                i.setData(Uri.parse("email:fsm@fsm.edu.tr"));
                startActivity(Intent.createChooser(i,"send mail"));*/
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
            }
        });
        buton_arama1 = (Button) root.findViewById(R.id.btn_rektorluk);
        buton_arama1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i= new Intent(Intent.ACTION_DIAL);
                 i.setData(Uri.parse("tel:2125218484"));
                 startActivity(i);
             }
         });
        buton_arama2 = (Button) root.findViewById(R.id.btn_fatih);
        buton_arama2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:2125218484"));
                startActivity(i);
            }
        });
        buton_arama3 = (Button) root.findViewById(R.id.btn_halic);
        buton_arama3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:2125218484"));
                startActivity(i);
            }
        });
        buton_arama4 = (Button) root.findViewById(R.id.btn_topkapi);
        buton_arama4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:2125218484"));
                startActivity(i);
            }
        });
        buton_arama5 = (Button) root.findViewById(R.id.btn_camlica);
        buton_arama5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:2125218484"));
                startActivity(i);
            }
        });
        buton_arama6 = (Button) root.findViewById(R.id.btn_kandilli);
        buton_arama6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:2125218484"));
                startActivity(i);
            }
        });
        buton_arama7 = (Button) root.findViewById(R.id.btn_uskudar);
        buton_arama7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:2125218484"));
                startActivity(i);
            }
        });



       // final TextView textView = root.findViewById(R.id.text_slideshow);
        /*slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }




}