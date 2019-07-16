package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Breed.class, version = 1)

abstract class BreedDatabase extends RoomDatabase {

    public abstract BreedDao breedDao();

    private static BreedDatabase INSTANCE;

    public static BreedDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BreedDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BreedDatabase.class, "breed_database")
                            .addCallback(breedDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static BreedDatabase.Callback breedDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();

                }

            };


    private static class PopulateDbAsync<breed> extends AsyncTask<Void, Void, Void> {

        private final BreedDao breedDao;

        PopulateDbAsync(BreedDatabase db) {
            breedDao = db.breedDao();

        }

            @Override

            protected Void doInBackground ( final Void...params){


                breedDao.deleteAll();
                Breed breed = new Breed();
                breedDao.insert(breed);

                return null;


            }


        }
    }

