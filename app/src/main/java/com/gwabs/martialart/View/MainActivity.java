package com.gwabs.martialart.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.gwabs.martialart.R;
import com.gwabs.martialart.RoomDB.MartialArt;
import com.gwabs.martialart.ViewModel.MartialArtViewModel;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ListItemLongClickListener{

    private MartialArtViewModel mMartialArtViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.recyclerview);
        MartialArtListAdapter artListAdapter = new MartialArtListAdapter(this,new MartialArtListAdapter.MartialArtDiff());




        rv.setAdapter(artListAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // view model provider will provide us with the view model
        // we initialize the viewModel
        mMartialArtViewModel = new ViewModelProvider(this).get(MartialArtViewModel.class);

        // setting an observer
        // submit list method
        mMartialArtViewModel.getAllMartialArts().observe(this, artListAdapter::submitList);

        findViewById(R.id.fab).setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this,NewMartialArtActivity.class);
            newMartialArtActivityResultLauncher.launch(intent);
        });
    }

    ActivityResultLauncher<Intent> newMartialArtActivityResultLauncher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        String favMa = data.getStringExtra(NewMartialArtActivity.KEY);
                        mMartialArtViewModel.insertMartialArt(new MartialArt(favMa));
                    }
                }
            }
    );

    @Override
    public void listItemLongClicked(MartialArt martialArt) {
        Toast.makeText(this, martialArt.mFavMartialArt.toString(), Toast.LENGTH_SHORT).show();
        new AlertDialog.Builder(this)
                .setTitle("Delete entry")
                .setCancelable(true)
                .setMessage("Are you sure you want to delete "+martialArt.mFavMartialArt)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mMartialArtViewModel.deleteMartialArt(martialArt);
                    }
                })
                .setIcon(R.drawable.ic_launcher_foreground)
                .show();

    }
}