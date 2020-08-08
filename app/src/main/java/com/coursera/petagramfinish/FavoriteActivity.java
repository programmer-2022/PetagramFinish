package com.coursera.petagramfinish;

import android.os.Bundle;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView recyclerFavoritePet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Toolbar toolbar = findViewById(R.id.myActionBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);

        this.recyclerFavoritePet = findViewById(R.id.recycler_favorite_pet);
        this.recyclerFavoritePet.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<Pet> petListFavorite = (ArrayList<Pet>) getIntent().getSerializableExtra("key_favorite_list");
        AdapterFavoritePet adapter = new AdapterFavoritePet(petListFavorite, this);
        this.recyclerFavoritePet.setAdapter(adapter);
    }
}