package com.gwabs.martialart.RoomDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {MartialArt.class}, version = 1, exportSchema = false)
public abstract class MartialArtRoomDatabase extends RoomDatabase {

    public abstract MartialArtDAO martialArtDAO();

    private static volatile MartialArtRoomDatabase INSTANCE;

    private static final int NUNBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUNBER_OF_THREADS);

    public static MartialArtRoomDatabase getDatabase(Context context) {

        if (INSTANCE == null) {

            synchronized (MartialArtRoomDatabase.class) {

                INSTANCE = Room.databaseBuilder(context, MartialArtRoomDatabase.class, "martial_art_database").addCallback(databaseCallback).build();

            }
        }
        return INSTANCE;
    }

    private static final Callback databaseCallback = new Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriterExecutor.execute(() -> {
                MartialArtDAO dao = INSTANCE.martialArtDAO();


                // deleting all martial art db
                dao.deleteAllMartialArts();

                // adding martial art to db

                dao.insertMartialArt(new MartialArt("Boxing"));
                dao.insertMartialArt(new MartialArt("Dambe"));
                dao.insertMartialArt(new MartialArt("Kick Boxing"));
                dao.insertMartialArt(new MartialArt("Kokuwa  Dambe"));

            });
        }
    };


}

