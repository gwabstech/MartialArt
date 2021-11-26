package com.gwabs.martialart.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gwabs.martialart.RoomDB.MartialArt;
import com.gwabs.martialart.RoomDB.MartialArtRepository;

import java.util.List;

public class MartialArtViewModel extends AndroidViewModel {

    private MartialArtRepository martialArtRepository;

    private final LiveData<List<MartialArt>> allMartialArts;

    public MartialArtViewModel(@NonNull Application application) {
        super(application);

        martialArtRepository = new MartialArtRepository(application);
        allMartialArts = martialArtRepository.getAllMartialArts();

    }

    public LiveData<List<MartialArt>> getAllMartialArts() {

        return allMartialArts;

    }


    public void insertMartialArt(MartialArt martialArt) {

        martialArtRepository.insertMartialArt(martialArt);

    }

    public void deleteMartialArt(MartialArt martialArt) {

        martialArtRepository.deleteMartialArt(martialArt);

    }

}
