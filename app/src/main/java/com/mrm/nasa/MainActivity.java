package com.mrm.nasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText enterTime;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterTime = findViewById(R.id.enterTime);
        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, InfoActivity.class);
            i.putExtra("date", enterTime.getText().toString());
            startActivity(i);
        });
    }
}