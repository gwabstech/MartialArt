package com.gwabs.martialart.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.gwabs.martialart.R;

public class MainActivity extends AppCompatActivity {

    MartialArtListAdapter artListAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.recyclerview);
        artListAdapter = new MartialArtListAdapter(new MartialArtListAdapter.MartialArtDiff());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(artListAdapter);

    }
}