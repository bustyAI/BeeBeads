package com.example.beebeads;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version = 1)
public abstract class AppDatebase extends RoomDatabase {

    // For Singleton strategy
    private static AppDatebase instance;

    // This is used to access our database operation methods
    public abstract UserDao userDao();

    // With the method we can get a handle to this context
    public static synchronized AppDatebase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDatebase.class,
                    "app_database").fallbackToDestructiveMigration().build();
        }

        return instance;
    }
}
