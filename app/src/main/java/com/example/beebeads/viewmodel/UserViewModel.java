package com.example.beebeads.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.beebeads.Bead;
import com.example.beebeads.User;
import com.example.beebeads.repository.AppRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    public static AppRepository repository;
    public final LiveData<List<User>> allUsers;

    public final LiveData<List<Bead>> allBeads;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
        allUsers = repository.getAllUsers();
        allBeads = repository.getAllBeads();
    }

    /**
     * User methods
     */
    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public static void insert(User user){
        repository.insert(user);
    }

    public static void update(User user) {
        repository.update(user);
    }

    public static void delete(User user){
        repository.delete(user);
    }

    public static void deleteAll(){
        repository.deleteAll();
    }


    /**
     * Bead methods
     */
    public static void insert(Bead bead) {
        repository.insert(bead);
    }

    public static void update(Bead bead) {
        repository.update(bead);
    }

    public static void delete(Bead bead){
        repository.delete(bead);
    }

    public static void deleteAllBeads(){
        repository.deleteAllBeads();
    }

    public LiveData<List<Bead>> getAllBeads() {
        return allBeads;
    }
}
