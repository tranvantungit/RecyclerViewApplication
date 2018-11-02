package com.example.tungtv.recyclerviewapplication;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    public final ObservableList<ListItem> consolidatedList = new ObservableArrayList<>();
    private final MutableLiveData<List<MyObject>> listMutableLiveData;

    public MainViewModel() {
        listMutableLiveData = new MutableLiveData<>();
        getAllObject();
    }

    public void getAllObject() {
        List<MyObject> myObjects = init();
        listMutableLiveData.setValue(myObjects);
    }

    @NonNull
    private List<MyObject> init() {
        List<MyObject> myObjects = new ArrayList<>();
        myObjects.add(new MyObject("name 1", "2016-06-21"));
        myObjects.add(new MyObject("name 2", "2016-06-05"));
        myObjects.add(new MyObject("name 2", "2016-06-05"));
        myObjects.add(new MyObject("name 3", "2016-05-17"));
        myObjects.add(new MyObject("name 3", "2016-05-17"));
        myObjects.add(new MyObject("name 3", "2016-05-17"));
        myObjects.add(new MyObject("name 3", "2016-05-17"));
        myObjects.add(new MyObject("name 2", "2016-06-05"));
        myObjects.add(new MyObject("name 3", "2016-05-17"));
        return myObjects;
    }

    public void addObjectsToList(List<ListItem> myObjects) {
        consolidatedList.addAll(myObjects);
    }

    public MutableLiveData<List<MyObject>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
