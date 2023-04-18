package com.example.beebeads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.test);

        userViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).
                create(UserViewModel.class);

        userViewModel.getAllUsers().observe(this, users -> {
            StringBuilder builder = new StringBuilder();
            for (User user : users){
                Log.d("User", "Hey " + user.getUsername() + " is this your password? " +
                        user.getPassword() + " admin? " + user.getAdmin() + " userId? " + user.getUserId());
                builder.append(user.getUsername()).append(" ");
            }
            textView.setText(builder.toString());


        });


    }
}