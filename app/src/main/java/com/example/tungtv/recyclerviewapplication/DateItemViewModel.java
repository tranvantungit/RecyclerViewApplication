package com.example.tungtv.recyclerviewapplication;

import android.databinding.ObservableField;

public class DateItemViewModel {
    public final ObservableField<String> date;

    public DateItemViewModel(String date) {
        this.date = new ObservableField<>(date);
    }
}
