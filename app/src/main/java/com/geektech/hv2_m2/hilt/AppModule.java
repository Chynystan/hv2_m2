package com.geektech.hv2_m2.hilt;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;


import com.geektech.hv2_m2.data.network.LoveApi;
import com.geektech.hv2_m2.data.pref.Prefs;
import com.geektech.hv2_m2.data.repo.LoveRepository;
import com.geektech.hv2_m2.data.room.LoveDao;
import com.geektech.hv2_m2.data.room.LoveDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {


    @Provides
    @Singleton
    public LoveApi provideApi(){
        return new Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(LoveApi.class);
    }

    @Provides
    public LoveRepository provideRepository(){
        return new LoveRepository(provideApi());
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPrefs(@ApplicationContext Context context){
        return context.getApplicationContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }

    @Provides
    public Prefs providePrefs(SharedPreferences preferences){
        return new Prefs(preferences);
    }

    @Provides
    @Singleton
    public static LoveDataBase provideDB(Application application) {
        return Room.databaseBuilder(application, LoveDataBase.class, LoveDataBase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    public static LoveDao provideUserDataDAO(LoveDataBase appDatabase) {
        return appDatabase.caseDao();
    }
}
