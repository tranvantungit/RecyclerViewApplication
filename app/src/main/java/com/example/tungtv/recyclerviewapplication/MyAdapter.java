package com.example.tungtv.recyclerviewapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tungtv.recyclerviewapplication.databinding.ItemDateViewBinding;
import com.example.tungtv.recyclerviewapplication.databinding.ItemGeneralViewBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<ListItem> listItems;

    public MyAdapter(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == ListItem.TYPE_DATE) {
            ItemDateViewBinding itemDateViewBinding = ItemDateViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()));
            return new DateViewHolder(itemDateViewBinding);
        } else {
            ItemGeneralViewBinding itemGeneralViewBinding = ItemGeneralViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()));
            return new GeneralViewHolder(itemGeneralViewBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
        baseViewHolder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listItems.get(position).getType();
    }

    public void addItems(List<ListItem> listItems) {
        this.listItems.addAll(listItems);
        notifyDataSetChanged();
    }

    class DateViewHolder extends BaseViewHolder {
        private DateItemViewModel mDateItemViewModel;
        private ItemDateViewBinding mBinding;

        public DateViewHolder(ItemDateViewBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final String date = ((DateItem) listItems.get(position)).getDate();
            mDateItemViewModel = new DateItemViewModel(date);
            mBinding.setViewModel(mDateItemViewModel);
        }
    }

    class GeneralViewHolder extends BaseViewHolder {
        private GeneralItemViewModel mGeneralItemViewModel;
        private ItemGeneralViewBinding mBinding;

        public GeneralViewHolder(ItemGeneralViewBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final MyObject myObject = ((GeneralItem) listItems.get(position)).getMyObject();
            mGeneralItemViewModel = new GeneralItemViewModel(myObject);
            mBinding.setViewModel(mGeneralItemViewModel);
        }
    }

    public void clearItems() {
        listItems.clear();
    }
}
