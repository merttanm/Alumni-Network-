package com.prevezene.mezunapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.prevezene.mezunapp.ui.login.DatabaseHelper;

/*
activity_register.xml e bağlı register sınıfı, tasarımda
TextView lerin içine girilen verileri btn_kaydet
butonuyla, onClick  fonksiyonunu kullanarak
ile DB' ye  dataları basarız.
* */
public class register extends AppCompatActivity {
    DatabaseHelper sqLiteDatabase;
    Button btn_giriş,btn_kaydet;
    EditText edt_kullanici,edt_kullaniciadi,edt_mail,edt_sifre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sqLiteDatabase= new DatabaseHelper(this);
        edt_kullanici=(EditText)findViewById(R.id.edt_kullanici);
        edt_kullaniciadi=(EditText)findViewById(R.id.edt_kullaniciadi);
        edt_mail=(EditText)findViewById(R.id.edt_mail);
        edt_sifre=(EditText)findViewById(R.id.edt_sifre);
        btn_kaydet=(Button)findViewById(R.id.btn_kaydet);
        // AddData fonksiyonunu çağırıyorum
        AddData();

    }

    /*
    DatabaseHelper classında oluşturmuş olduğum insert fonksiyonunu
    kullanarak data ekleriz.
    */

    public  void AddData() {
        btn_kaydet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = sqLiteDatabase.insert(
                                edt_kullanici.getText().toString(),
                                edt_kullaniciadi.getText().toString(),
                                edt_mail.getText().toString(),
                                edt_sifre.getText().toString());
                        if(isInserted == true) {
                            Toast.makeText(register.this, "kayıt tamam", Toast.LENGTH_LONG).show();

                             Intent giris= new Intent(register.this,MainActivity.class);
                            Toast.makeText(register.this, "Hoşgeldiniz...", Toast.LENGTH_LONG).show();
                             startActivity(giris);
                        }
                        else
                            Toast.makeText(register.this,"yüklenmiyor ",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }







}