package com.example.bhargavdesai_project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MangaDetails extends AppCompatActivity {
    TextView txtDTitle;
    TextView txtAuthor;
    TextView txtPrice;
    TextView txtPublicationYear;
    TextView txtDescription;
    ImageView mangaPic;


    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_page);

        Intent i = getIntent(); // get intent from previous activity

        // get data passed by previous activity
        String photo = i.getStringExtra("photo");
        String title = i.getStringExtra("title");
        String author = i.getStringExtra("author");
        String description = i.getStringExtra("description");
        int price = i.getIntExtra("price", 0);
        int publication_year = i.getIntExtra("publication_year", 2020);

        txtDTitle = findViewById(R.id.txtDTitle);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtPrice = findViewById(R.id.txtPrice);
        txtPublicationYear = findViewById(R.id.txtPublicationYear);
        txtDescription = findViewById(R.id.txtDescription);
        mangaPic = findViewById(R.id.mangaPic);
        btnBuy = findViewById(R.id.btnBuy);

        // fetch image and display it in mangaPic
        StorageReference storRef = FirebaseStorage.getInstance().getReferenceFromUrl(photo);
        Glide.with(this).load(storRef).into(mangaPic);

        // display information
        txtDTitle.setText(title);
        txtAuthor.setText(author);
        txtDescription.setText(description);
        txtPrice.setText("¥" + Integer.toString(price));
        txtPublicationYear.setText("published in\n\t\t" + Integer.toString(publication_year));

        // when buy button gets clicked
        btnBuy.setOnClickListener(view -> {
            Intent ic = new Intent(MangaDetails.this, CheckoutActivity.class); //to start new activity (here checkout activity)
            ic.putExtra("title", title); // pass title

            startActivity(ic); // start activity
        });
    }
}
