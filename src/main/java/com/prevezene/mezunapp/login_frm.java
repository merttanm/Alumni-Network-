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
Uygulamaya giriş yapıldığı zaman bizi activity_login.xml
karşılıyor bu sayfada var olan kayıtla giriş yapabiliriz
veya kayıt ol butonuna tıkayarak activity_register.xml
sayfasında kayıt oluşturabiliriz
*/

public class login_frm extends AppCompatActivity {
     Button button3, button_giris;
     EditText e1,e2;
     DatabaseHelper db;


     public void init(){
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy= new Intent(login_frm.this,register.class);
                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
//        ekle();
        db =new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);
        button_giris=(Button)findViewById(R.id.buttongiris);
        button_giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edt_mail = e1.getText().toString();//burada edt lkalkabilir
                String  edt_password = e2.getText().toString();
                Boolean chkemailpassword =db.emailpassword(edt_mail,edt_password);
                if(chkemailpassword==true){
                    Toast.makeText(getApplicationContext(),"HOŞGELDİNİZ", Toast.LENGTH_SHORT).show();
                Intent anasayfayazıpla= new Intent(login_frm.this,MainActivity.class);
                startActivity(anasayfayazıpla);

                }

            else
                    Toast.makeText(getApplicationContext(),"başarsız giriş", Toast.LENGTH_SHORT).show();



            }
        });
    }

}
