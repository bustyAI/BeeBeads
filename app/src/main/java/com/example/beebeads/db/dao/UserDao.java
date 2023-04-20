package com.example.beebeads.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.beebeads.User;
import com.example.beebeads.db.AppDatebase;

import java.util.List;

// DB methods for user
@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM " + AppDatebase.USER_TABLE)
    void deleteAll();

    @Query("SELECT * FROM " + AppDatebase.USER_TABLE + " ORDER BY userId DESC")
    LiveData<List<User>> getAllUsers();

}
