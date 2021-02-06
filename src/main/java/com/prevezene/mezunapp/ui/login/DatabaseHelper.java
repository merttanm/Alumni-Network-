package com.prevezene.mezunapp.ui.login;


import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.content.ContentValues.*;

import androidx.annotation.Nullable;

import com.prevezene.mezunapp.user;

import java.util.ArrayList;
import java.util.List;


/*
Veri tabanı katmanlı bir mimariyi beraberinde getirir .Veri tabanın kendi durduğu bir katman var
bunun üstünde veri tabanına erişmeyi  sağlayan DB acces (veri tabanı erişim) katmanı oluyor bunu
üstünde ise uygulama çalışmaktadır. Benim geliştirdiğim uygulamadan veri tabanını Android kendisi
tutmaktadır, veri tabanı ile doğrudan muhatap olmuyorum ama veri tabanına erişimi sağlayan ayrı
bir kod yazıyorum. Bunun amacı ilerde veri tabanında bir değişiklik yaptığım zaman mesela veri
tabanına yeni tablolar eklersem, değişiklik yaparsam o kodu yeniden yazmak ya da teker teker
aramak yerine bunu erişim katmanından kolaylıkla çözmek. Veri tabanı erişim katmanı nesne
programlama ile yazdığım için verileri bir nesne olarak tutuyoruz. Bunun için
DatabaseHelper sınıfını oluşturdum.
Android uygulamamda veritabanı yaratmak ve upgrade etmek için SQLiteOpenHelper sınıfını extend
kullanıyorum  SQLiteOpenHelper sınıfı üzerinden Android SDK ile konuşacağız
*/
public class DatabaseHelper extends SQLiteOpenHelper {
    // Sabitler
    public static final String DATABASE_NAME = "login.sqLiteDatabase";
    public static final String TABLE_NAME = "user";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "EMAIL";
    public static final String COL_4 = "PASSWORD";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    // Veri tabanı tablo sutun adlarını vererek, tablo oluşturuyorum
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY  AUTOINCREMENT, NAME TEXT,EMAIL TEXT,PASSWORD TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(" drop table if exists " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }



    ////// Veri tabanında oluşturmuş olduğum sütunlara kayıt ekliyorum
    public boolean insert(String edt_mail, String edt_sifre, String edt_kullanici, String edt_kullaniciadi) {


        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        // ContentValues objesi oluşturuyorum ve bunu içine aldığım parametleri gönderiyorum
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, edt_kullanici);
        contentValues.put(COL_2, edt_kullaniciadi);
        contentValues.put(COL_3, edt_mail);
        contentValues.put(COL_4, edt_sifre);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return
                    false;
        else
            return
                    true;


    }

    // Email ve password kayıt kontrolü yapıyor
    public Boolean emailpassword(String edt_mail, String edt_sifre) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where EMAIL=? and PASSWORD=?", new String[]{edt_mail, edt_sifre});

        // Cursor sınıfı içerisinde bulunan getCount() metodu sayesinde, query işlemi sonucunda ne kadar satır döndüğünü bulabiliriz.
        if (cursor.getCount() > 0) return true;
        else return false;

    }



public boolean updateData (String edt_mail, String edt_sifre, String edt_kullanici, String edt_kullaniciadi){
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    // ContentValues objesi oluşturuyorum ve bunu içine aldığım parametleri gönderiyorum
    ContentValues contentValues = new ContentValues();

    contentValues.put(COL_1, edt_kullanici);
    contentValues.put(COL_2, edt_kullaniciadi);
    contentValues.put(COL_3, edt_mail);
    contentValues.put(COL_4, edt_sifre);
    sqLiteDatabase.update(TABLE_NAME,contentValues,"ID = ?", new String[]{edt_kullanici});

    return true;

}




    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
