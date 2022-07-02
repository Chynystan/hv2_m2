package com.geektech.hv2_m2.ui.fragment.main.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.geektech.hv2_m2.data.entity.LoveModel;
import com.geektech.hv2_m2.data.repo.LoveRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoveViewModel extends ViewModel {

    LoveRepository repository;

    @Inject
    public LoveViewModel(LoveRepository repository) {
        this.repository = repository;
    }

    public LiveData<LoveModel> getModel(String firstName, String secondName){
        return repository.getModel(firstName, secondName);
    }
}
