package com.gwabs.martialart.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// here we tell the system that this is DAO class
@Dao
public interface MartialArtDAO {

    // this method allow us to insert to our DB
    @Insert
    void insertMartialArt(MartialArt martialArt);

    @Query("Delete FROM martial_art_table")
    void deleteAllMartialArts();

   // this method delete single item
    @Delete
    void deleteMartialArt(MartialArt martialArt);

    // this method get and order by Alphabetical
    @Query("Select * FROM martial_art_table ORDER BY fav_martial_art ASC ")
    LiveData<List<MartialArt>> getAllMartialArtsInAnAlphabeticalOrder();


}
