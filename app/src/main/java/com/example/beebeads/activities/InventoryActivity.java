package com.example.beebeads.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.beebeads.Bead;
import com.example.beebeads.R;
import com.example.beebeads.viewmodel.UserViewModel;

import java.util.List;
import java.util.Objects;

public class InventoryActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iventory);

        TextView inventory = findViewById(R.id.inventory);

        userViewModel = new ViewModelProvider.AndroidViewModelFactory(InventoryActivity.this.
                getApplication()).create(UserViewModel.class);

        userViewModel.getAllBeads().observe(this, beads -> {
            StringBuilder temp = new StringBuilder();
            for (Bead bead: beads){
                temp.append(bead.getColor()).append("\t\t").append(bead.getAmount()).append("\n");
            }
            inventory.setText(temp.toString());
        });


    }
}