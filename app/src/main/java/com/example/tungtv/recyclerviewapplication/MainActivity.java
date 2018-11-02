package com.example.tungtv.recyclerviewapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tungtv.recyclerviewapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private List<MyObject> myOptions = new ArrayList<>();
    List<ListItem> consolidatedList;

//    private RecyclerView mRecyclerView;
    private MyAdapter adapter;
    MainViewModel mainViewModel;
    LinearLayoutManager layoutManager;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        consolidatedList = new ArrayList<>();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.viewModel, mainViewModel);
        binding.executePendingBindings();


        //mainViewModel.getAllObject();

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new MyAdapter(new ArrayList<>());
        binding.recyclerData.setLayoutManager(layoutManager);
        binding.recyclerData.setAdapter(adapter);



        mainViewModel.getListMutableLiveData().observe(this, myObjects -> {
            HashMap<String, List<MyObject>> hashMap = groupDataIntoHashMap(myObjects);
            for (String date : hashMap.keySet()) {
                DateItem dateItem = new DateItem();
                dateItem.setDate(date);
                consolidatedList.add(dateItem);

                for (MyObject myObject : hashMap.get(date)) {
                    GeneralItem generalItem = new GeneralItem();
                    generalItem.setMyObject(myObject);
                    consolidatedList.add(generalItem);
                }
            }

            mainViewModel.addObjectsToList(consolidatedList);
        });
    }

    private HashMap<String, List<MyObject>> groupDataIntoHashMap(List<MyObject> myObjects) {
        HashMap<String, List<MyObject>> groupedHashMap = new HashMap<>();

        for (MyObject myObject : myObjects) {
            String hashMapKey = myObject.getDate();
            if (groupedHashMap.containsKey(hashMapKey)) {
                // The key is already in the HashMap; add the pojo object
                // against the existing key.
                groupedHashMap.get(hashMapKey).add(myObject);
            } else {
                // The key is not there in the HashMap; create a new key-value pair
                List<MyObject> list = new ArrayList<>();
                list.add(myObject);
                groupedHashMap.put(hashMapKey, list);
            }
        }

        return groupedHashMap;
    }
}
