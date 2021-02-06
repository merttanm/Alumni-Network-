package com.prevezene.mezunapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class mezunPlatformuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public mezunPlatformuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}