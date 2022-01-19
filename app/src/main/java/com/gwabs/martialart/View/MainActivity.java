package com.gwabs.martialart.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.gwabs.martialart.R;
import com.gwabs.martialart.ViewModel.MartialArtViewModel;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private MartialArtViewModel mMartialArtViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.recyclerview);
        MartialArtListAdapter artListAdapter = new MartialArtListAdapter(new MartialArtListAdapter.MartialArtDiff());




        rv.setAdapter(artListAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // view model provider will provide us with the view model
        // we initialize the viewModel
        mMartialArtViewModel = new ViewModelProvider(this).get(MartialArtViewModel.class);

        // setting an observer
        // submit list method
        mMartialArtViewModel.getAllMartialArts().observe(this, artListAdapter::submitList);
    }
}