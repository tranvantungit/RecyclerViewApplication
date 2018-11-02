package com.example.tungtv.recyclerviewapplication;

public class DateItem extends ListItem {
    private String date;
    @Override
    public int getType() {
        return TYPE_DATE;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
