package com.example.livinglab_cultureplatform;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> title = new MutableLiveData<>();
    public MutableLiveData<String> place = new MutableLiveData<>();
    public MutableLiveData<String> price = new MutableLiveData<>();
    public MutableLiveData<String> pNum = new MutableLiveData<>();
    public MutableLiveData<String> date = new MutableLiveData<>();
    //public SingleLiveEvent onClickEvent = new SingleLiveEvent();
    //public void addEvent(){
       // onClickEvent.call();
    }


//}
