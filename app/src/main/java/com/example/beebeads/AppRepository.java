package com.example.beebeads;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

// Repository for handling retrieving, deleting, updating our data
public class AppRepository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public AppRepository(Application application){
        AppDatebase db = AppDatebase.getDatabase(application);
        userDao = db.userDao();
        allUsers = userDao.getAllUsers();
    }

    public void insert(User user){
        AppDatebase.dbExecutor.execute(() ->{
            userDao.insert(user);
        });
    }

    public void update(User user){
       AppDatebase.dbExecutor.execute(() ->
               userDao.update(user));
    }

    public void delete(User user){
        AppDatebase.dbExecutor.execute(() ->
                userDao.delete(user));
    }

    public void deleteAll(){
        AppDatebase.dbExecutor.execute(() ->
                userDao.deleteAll());
    }

    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }


}
