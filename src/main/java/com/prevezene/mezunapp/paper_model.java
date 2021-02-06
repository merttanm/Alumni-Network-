package com.prevezene.mezunapp;

import com.google.gson.annotations.SerializedName;
/*
Model oluşturuyorum, model oluşturmak benim herhangi bir
veri setinden gelen verileri sınıflaştırmaya ve o sınıfı
kullanarak işlem yaptırmama yarıyor.Benim “paper” diye
değişkenleri olan bir sınıf oluşturuyorum ve bundan
sonraki tüm verileri bu modele atayarak işlem yapıyorum.
*/
public class paper_model {
 /*
 Retrofite, ben JSON şeklinde bir veri alıyorum ve
 bu JSON şeklinde aldığım verinin başlığı da paper_one
 olacak diyorum.
 */
    @SerializedName("paper_one")
    public String paper_one;
    @SerializedName("paper_two")
    public String paper_two;
    @SerializedName("paper_three")
    public String paper_three;
    @SerializedName("paper_four")
    public String paper_four;
    @SerializedName("paper_five")
    public String paper_five;

    @SerializedName("paper_six")
    public String paper_six;


}
