package com.example.tungtv.recyclerviewapplication;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public final class BindingUtils {
    public BindingUtils() {
    }

    @BindingAdapter({"adapter"})
    public static void addItems(RecyclerView recyclerView, List<ListItem> listItems) {
        MyAdapter adapter = (MyAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(listItems);
            adapter.notifyDataSetChanged();
        }
    }
}
