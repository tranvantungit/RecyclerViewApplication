package com.example.tungtv.recyclerviewapplication;

public class GeneralItem extends ListItem {
    private MyObject myObject;

    public MyObject getMyObject() {
        return myObject;
    }

    public void setMyObject(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public int getType() {
        return TYPE_GENERAL;
    }
}
