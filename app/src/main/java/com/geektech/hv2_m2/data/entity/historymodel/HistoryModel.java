package com.geektech.hv2_m2.data.entity.historymodel;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class HistoryModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String firstName;
    private String secondName;
    private String result;

    @Ignore
    public HistoryModel(String firstName, String secondName, String result) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.result = result;
    }

    public HistoryModel(int id, String firstName, String secondName, String result) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.result = result;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getResult() {
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
