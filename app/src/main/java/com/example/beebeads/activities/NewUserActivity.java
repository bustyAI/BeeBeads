package com.example.beebeads.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.beebeads.Bead;
import com.example.beebeads.R;
import com.example.beebeads.viewmodel.UserViewModel;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        EditText redBeadInput = findViewById(R.id.redBead);
        EditText greenBeadInput = findViewById(R.id.greenBead);
        EditText blueBeadInput = findViewById(R.id.blueBead);

        Button stashBtn = findViewById(R.id.stashButton);

        stashBtn.setOnClickListener(view -> {
            if(!TextUtils.isEmpty(redBeadInput.getText()) ) {
                Bead bead = new Bead("red", Integer.parseInt(redBeadInput.getText().toString()));
                UserViewModel.insert(bead);
            }

            if (!TextUtils.isEmpty(greenBeadInput.getText())) {
                Bead bead = new Bead("green", Integer.parseInt(greenBeadInput.getText().toString()));
                UserViewModel.insert(bead);
            }

            if (!TextUtils.isEmpty(blueBeadInput.getText())){
                Bead bead = new Bead("blue", Integer.parseInt(blueBeadInput.getText().toString()));
                UserViewModel.insert(bead);
            }
            Intent landingIntent= new Intent(NewUserActivity.this, LandingPageActivity.class);
            startActivity(landingIntent);
        });

    }
}