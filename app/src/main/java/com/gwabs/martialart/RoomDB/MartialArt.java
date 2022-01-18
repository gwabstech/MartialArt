package com.gwabs.martialart.RoomDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// hear we set the table name
@Entity(tableName = "martial_art_table")
public class MartialArt {

    // we set the String value  as primary key using the annotation
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="fav_martial_art")
    public String mFavMartialArt;

    // constructor
    public MartialArt(@NonNull String favMartialArt) {

        mFavMartialArt = favMartialArt;

    }

    // this getter method to get the items in our room db

    @NonNull
    public String getmFavMartialArt() {
        return mFavMartialArt;
    }
}
