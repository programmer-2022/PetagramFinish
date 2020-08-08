package com.coursera.petagramfinish;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pet> petList;
    private RecyclerView petRecycler;
    private ArrayList<Pet> petListFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.myActionBar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        this.initComponents();
        this.fillPetList();
        AdapterPet adapter = new AdapterPet(this.petList, this);
        this.petRecycler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favorite_pet) {
            openActivityFavoritePet();
        }

        if (id == R.id.action_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openActivityFavoritePet() {

        //Create new pet list favorite
        this.petListFavorite = new ArrayList<>();

        if(petList.size() > 0) {
            for (Pet p: petList) {
                boolean like = p.isLike();
                if(like) this.petListFavorite.add(p);
            }
        }

        if(this.petListFavorite.size() > 0) {
            Intent intent = new Intent(this, FavoriteActivity.class);
            intent.putExtra("key_favorite_list", this.petListFavorite);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), R.string.msg_no_pets_list , Toast.LENGTH_SHORT).show();
        }
    }

    private void initComponents() {
        this.petList = new ArrayList<>();
        this.petRecycler = findViewById(R.id.recycler_pets);
        this.petRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fillPetList() {
        this.petList.add(new Pet(R.drawable.koala, getResources().getString(R.string.koala),
                String.format(getString(R.string.format_like),
                        Integer.parseInt(getString(R.string.koala_value)))));

        this.petList.add(new Pet(R.drawable.monkey, getResources().getString(R.string.monkey),
                String.format(getString(R.string.format_like),
                        Integer.parseInt(getString(R.string.monkey_value)))));

        this.petList.add(new Pet(R.drawable.panda, getResources().getString(R.string.panda),
                String.format(getString(R.string.format_like),
                        Integer.parseInt(getString(R.string.panda_value)))));

        this.petList.add(new Pet(R.drawable.pig, getResources().getString(R.string.pig),
                String.format(getString(R.string.format_like),
                        Integer.parseInt(getString(R.string.pig_value)))));

        this.petList.add(new Pet(R.drawable.rooster, getResources().getString(R.string.rooster),
                String.format(getString(R.string.format_like),
                        Integer.parseInt(getString(R.string.rooster_value)))));

        this.petList.add(new Pet(R.drawable.bear, getResources().getString(R.string.bear),
                String.format(getString(R.string.format_like),
                        Integer.parseInt(getString(R.string.bear_value)))));

        this.petList.add(new Pet(R.drawable.tiger, getResources().getString(R.string.tiger),
                String.format(getString(R.string.format_like),
                        Integer.parseInt(getString(R.string.tiger_value)))));

        this.petList.add(new Pet(R.drawable.frog, getResources().getString(R.string.frog),
                String.format(getString(R.string.format_like),
                        Integer.parseInt(getString(R.string.frog_value)))));

        this.petList.add(new Pet(R.drawable.fox, getResources().getString(R.string.fox),
                String.format(getString(R.string.format_like),
                        Integer.parseInt(getString(R.string.fox_value)))));
    }
}