package com.example.beebeads;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatebase extends RoomDatabase {

    public static final String DB_NAME = "BEAD_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";

    public static final String BEAD_TABLE = "BEAD_TABLE";

    // For Singleton strategy
    private static volatile AppDatebase instance;

    // This is used to access our database operation methods
    public abstract UserDao userDao();

    public static final int THREADS = 4;

    // For execution of our db methods not on main thread
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static AppDatebase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (AppDatebase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), AppDatebase.class,
                            AppDatebase.DB_NAME).addCallback(callback).build();
                }
            }
        }
        return instance;
    }

    // Create db on creation of our app populated
    private static final RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                UserDao userDao = instance.userDao();

                User user = new User("Monty", "123456789", 0);
                userDao.insert(user);
                userDao.insert(new User("Python", "gitgood", 1));
            });
        }
    };

}