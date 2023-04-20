package com.example.beebeads.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.beebeads.Bead;
import com.example.beebeads.User;
import com.example.beebeads.db.AppDatebase;
import com.example.beebeads.db.dao.BeadDao;
import com.example.beebeads.db.dao.UserDao;

import java.util.List;

// Repository for handling retrieving, deleting, updating our data
public class AppRepository {
    private UserDao userDao;
    private BeadDao beadDao;
    private LiveData<List<User>> allUsers;

    private LiveData<List<Bead>> allBeads;

    public AppRepository(Application application){
        AppDatebase db = AppDatebase.getDatabase(application);
        userDao = db.userDao();
        beadDao = db.beadDao();
        allUsers = userDao.getAllUsers();
        allBeads = beadDao.getAllBeads();
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

    /**
     * Bead db methods
     */
    public void insert(Bead bead) {
        AppDatebase.dbExecutor.execute(() ->
                beadDao.insert(bead));
    }

    public void update(Bead bead) {
        AppDatebase.dbExecutor.execute(() ->
                beadDao.update(bead));
    }

    public void delete(Bead bead){
        AppDatebase.dbExecutor.execute(() ->
                beadDao.delete(bead));
    }

    public void deleteAllBeads(){
        AppDatebase.dbExecutor.execute(() ->
                beadDao.deleteAllBeads());
    }

    public LiveData<List<Bead>> getAllBeads() {
        return allBeads;
    }




}
