package com.prevezene.mezunapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.prevezene.mezunapp.ui.login.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class profil extends AppCompatActivity {
    Button buton_geri, add_photo;
    ImageView imageView2;
    //u userDbhelper;
    DatabaseHelper sqLiteDatabase;
    EditText k_adi, adi, okulno, sifre;
    static final int SELECT_IMAGE=12;
    Uri imageUri;

    public void anasayfayadon(){
        buton_geri=(Button)findViewById(R.id.button_geri);
        buton_geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent aracılığıyla activity_profil den activity_main' e geçiş yaparız.
                Intent toy= new Intent(profil.this,MainActivity.class);
                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        imageView2=findViewById(R.id.imageView2);
        add_photo=findViewById(R.id.add_photo);
        //add photo
        add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_GET_CONTENT);
                //DOSYA TİP BELİRLİYORUM
                intent.setType("image/*");
                startActivityForResult(intent,SELECT_IMAGE);
            }
        });
        anasayfayadon();
        sqLiteDatabase =new DatabaseHelper(this);
        viewAll();




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE && requestCode == RESULT_OK) {
            data.getData();
            imageView2.setImageURI(imageUri);
        }
    }

    private void viewAll() {
        k_adi= (EditText)findViewById(R.id.txt_kullaniciadigoster);
        adi= (EditText)findViewById(R.id.txt_adigoster);
        okulno= (EditText)findViewById(R.id.txt_okulnogoster);
        sifre= (EditText)findViewById(R.id.txt_şifregoster);
        Cursor res = sqLiteDatabase.getAllData();
        if (res.moveToFirst()) {
            int kadi = res.getInt(0);
            String aadi = res.getString(1);
            String  no = res.getString(2);
            String  sifresi = res.getString(3);

             k_adi.setId(kadi);
             adi.setText(aadi);
            okulno.setText(no);
            sifre.setText(sifresi);

        }
    }

/*
    public void viewAll(View view) {


    }*/
}