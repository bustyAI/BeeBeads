package com.example.beebeads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        EditText redBeadInput = findViewById(R.id.redBead);
        EditText greenBeadInput = findViewById(R.id.greenBead);
        EditText blueBeadInput = findViewById(R.id.blueBead);

        Button stashBtn = findViewById(R.id.stashButton);

    }
}