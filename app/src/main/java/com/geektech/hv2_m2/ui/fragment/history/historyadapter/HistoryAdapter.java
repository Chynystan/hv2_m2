package com.geektech.hv2_m2.ui.fragment.history.historyadapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.geektech.hv2_m2.data.entity.historymodel.HistoryModel;
import com.geektech.hv2_m2.databinding.ItemHistoryBinding;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private final List<HistoryModel> list = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void addItem(List<HistoryModel> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHistoryBinding binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.txtMe.setText(list.get(position).getFirstName());
        holder.binding.txtYou.setText(list.get(position).getSecondName());
        holder.binding.txtResult.setText(list.get(position).getResult());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ItemHistoryBinding binding;
        public ViewHolder(ItemHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
