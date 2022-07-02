package com.geektech.hv2_m2.ui.fragment.history;

import android.annotation.SuppressLint;


import com.geektech.hv2_m2.R;
import com.geektech.hv2_m2.base.BaseFragment;
import com.geektech.hv2_m2.data.entity.historymodel.HistoryModel;
import com.geektech.hv2_m2.data.room.LoveDao;
import com.geektech.hv2_m2.databinding.FragmentHistoryBinding;
import com.geektech.hv2_m2.ui.fragment.history.historyadapter.HistoryAdapter;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HistoryFragment extends BaseFragment<FragmentHistoryBinding> {

    @Inject
    LoveDao loveDao;
    private final HistoryAdapter adapter = new HistoryAdapter();

    @Override
    protected FragmentHistoryBinding bind() {
        return FragmentHistoryBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        initAdapter();
        initResult();
        sortByAlphabet();
    }

    @Override
    protected void setupObserver() {
        super.setupObserver();
        toMenu();
    }

    private void toMenu() {
        binding.toMainHistory.setOnClickListener(v -> controller.navigate(R.id.mainFragment));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void sortByAlphabet() {
        adapter.addItem(loveDao.getAllLovesByAlphabet());
    }

    private void initResult() {
        if (getArguments() != null){
            String percentage = getArguments().getString("percentage");
            String firstName = getArguments().getString("firstName");
            String secondName = getArguments().getString("secondName");
            loveDao.addLove(new HistoryModel(firstName, secondName, percentage));
            sortByAlphabet();
        }
    }

    private void initAdapter() {
        binding.rvItem.setAdapter(adapter);
    }
}