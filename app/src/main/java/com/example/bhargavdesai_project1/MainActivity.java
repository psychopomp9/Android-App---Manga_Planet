package com.example.bhargavdesai_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnProducts;
    TextView txtAppName;
    TextView txtAppHighlight;
    TextView txtAppDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        connect components with design layout
        txtAppName = findViewById(R.id.txtAppName);
        txtAppHighlight = findViewById(R.id.txtAppHeighlight);
        txtAppDesc = findViewById(R.id.txtAppDesc);
        btnProducts = findViewById(R.id.btnProducts);

//        set text to displays
        txtAppName.setText("Manga_Planet");
        txtAppHighlight.setText("Welcome to Manga Planet!");
        txtAppDesc.setText("Discover your next manga to read, buy it and start reading it!");

//        called when button is clicked
        btnProducts.setOnClickListener(view -> {
//            will take to new activity (here product activity)
            Intent i = new Intent(MainActivity.this, ProductActivity.class);

//            start new activity
            startActivity(i);
        });
    }
}