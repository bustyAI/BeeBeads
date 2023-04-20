package com.example.beebeads;

import android.content.Intent;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = AppDatebase.BEAD_TABLE)
public class Bead {

    @PrimaryKey(autoGenerate = true)
    private int beadId;

    private String color;

    private Integer amount;

    public Bead(String color, Integer amount) {
        this.color = color;
        this.amount = amount;

    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public int getBeadId() {
        return beadId;
    }

    public void setBeadId(int beadId) {
        this.beadId = beadId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
