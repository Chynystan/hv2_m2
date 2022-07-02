package com.geektech.hv2_m2.data.network;



import com.geektech.hv2_m2.data.entity.LoveModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LoveApi {

    @GET("getPercentage")
    Call<LoveModel> calculate(@Query("fname") String firstName,
                              @Query("sname") String secondName,
                              @Header("X-RapidAPI-Key") String key,
                              @Header("X-RapidAPI-Host") String host);
}
