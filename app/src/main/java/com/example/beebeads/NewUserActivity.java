package com.example.beebeads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        });

    }
}