package com.example.beebeads;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.beebeads.db.AppDatebase;

// User Table
@Entity(tableName = AppDatebase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int userId;

    private String username;
    private String password;

    private int admin;

    public User(String username, String password, int admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
