package com.example.bhargavdesai_project1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ProductActivity extends AppCompatActivity {

    private Query query;
    private MangaAdapter adapter;
    private RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_page);

        query = FirebaseDatabase.getInstance().getReference().child("Manga"); // like sql query to get data from firebase from "Manga" child
        FirebaseRecyclerOptions<Manga> options = new FirebaseRecyclerOptions.Builder<Manga>().setQuery(query, Manga.class).build();


        // setting up recycler view
        adapter = new MangaAdapter(options);

        rView = findViewById(R.id.rView);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}
