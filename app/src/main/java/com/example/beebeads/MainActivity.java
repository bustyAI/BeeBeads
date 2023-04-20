package com.example.beebeads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;

    private EditText enterUsername;
    private EditText enterPassword;

    private Button loginButton;
    private Button signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).
                create(UserViewModel.class);

        enterUsername = findViewById(R.id.username);
        enterPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        signUpButton = findViewById(R.id.signup);

        signUpButton.setOnClickListener(view -> {

            if (!TextUtils.isEmpty(enterUsername.getText())
                    && !TextUtils.isEmpty(enterPassword.getText())) {
                User user = new User(enterUsername.getText().toString(), enterPassword.getText().
                        toString(), 0);

                UserViewModel.insert(user);
                Intent newUserIntent = new Intent(MainActivity.this, NewUserActivity.class);
                startActivity(newUserIntent);

            } else {
                Toast.makeText(this, R.string.empty, Toast.LENGTH_SHORT).show();
            }
        });


        userViewModel.getAllUsers().observe(this, users -> {
            StringBuilder builder = new StringBuilder();
            for (User user : users){
                Log.d("User", "Hey " + user.getUsername() + " is this your password? " +
                        user.getPassword() + " admin? " + user.getAdmin() + " userId? " + user.getUserId());
                builder.append(user.getUsername()).append(" ");
            }

        });


    }
}