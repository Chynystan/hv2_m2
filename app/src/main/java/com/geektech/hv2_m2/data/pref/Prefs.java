package com.geektech.hv2_m2.data.pref;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class Prefs {

    public final static String BOARD_KEY = "board_key";
    private SharedPreferences prefs;

    @Inject
    public Prefs(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public void isShowed() {
        prefs.edit().putBoolean(BOARD_KEY, true).apply();
    }

    public boolean isShown() {
        return prefs.getBoolean(BOARD_KEY, false);
    }
}
