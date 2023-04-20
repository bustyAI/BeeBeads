package com.example.beebeads.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.beebeads.R;

public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        Button inventoryBtn = findViewById(R.id.checkInventory);

        inventoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkInventoryIntent = new Intent(LandingPageActivity.this, InventoryActivity.class);
                startActivity(checkInventoryIntent);
            }
        });
    }
}