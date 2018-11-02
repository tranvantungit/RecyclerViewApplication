package com.example.tungtv.recyclerviewapplication;

import android.databinding.ObservableField;

public class GeneralItemViewModel {
    public final ObservableField<String> event;

    public GeneralItemViewModel(MyObject myObject) {
        this.event = new ObservableField<>(myObject.getName());
    }
}
