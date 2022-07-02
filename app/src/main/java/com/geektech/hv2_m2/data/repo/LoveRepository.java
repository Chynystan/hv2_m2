package com.geektech.hv2_m2.data.repo;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;


import com.geektech.hv2_m2.data.entity.LoveModel;
import com.geektech.hv2_m2.data.network.LoveApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoveRepository {

    public static final String KEY = "fcf01ff652mshaec969ccd6aaceap1b5b91jsna3743dce8599";
    public static final String HOST = "love-calculator.p.rapidapi.com";
    LoveApi loveApi;

    @Inject
    public LoveRepository(LoveApi loveApi) {
        this.loveApi = loveApi;
    }

    public MutableLiveData<LoveModel> getModel(String firstName, String secondName){
        MutableLiveData<LoveModel> liveData = new MutableLiveData<>();
        loveApi.calculate(firstName, secondName, KEY, HOST).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(@NonNull Call<LoveModel> call,
                                   @NonNull Response<LoveModel> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        liveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoveModel> call, @NonNull Throwable t) {
            }
        });
        return liveData;
    }
}
