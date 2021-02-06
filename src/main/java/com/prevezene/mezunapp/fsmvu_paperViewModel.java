package com.prevezene.mezunapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class fsmvu_paperViewModel extends ViewModel {
//Model sınıfının kullanım ömrünü daha iyi kullanabilmesi için LiveData kullandım.
    private MutableLiveData<String> mText;

    public fsmvu_paperViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}