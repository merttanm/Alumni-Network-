package com.prevezene.mezunapp;

import java.util.List;

public class user_model {
    public int image;
    public String title;
    public String desc;
    public String toolbar_title3;
    public String toolbar_title1;


    public user_model(int image, String title, String desc, String toolbar_title3, String toolbar_title1) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.toolbar_title3 = toolbar_title3;
        this.toolbar_title1 = toolbar_title1;
    }
/*activity_detail2
    public user_model(List<user_model> models, mezunlarimiz mezunlarimiz) {

    }*/

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getToolbar_title3() {return toolbar_title3; }

    public void setToolbar_title3(String toolbar_title3) { this.toolbar_title3 = toolbar_title3; }

    public String getToolbar_title1() { return toolbar_title1; }

    public void setToolbar_title1(String toolbar_title1) { this.toolbar_title1 = toolbar_title1; }
}
