package com.schulz.erica.dogbreeds;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BreedRepository {

    private BreedDao breedDao;
    private LiveData<List<Breed>> allBreeds;

    BreedRepository(Application application) {
        BreedDatabase db = BreedDatabase.getDatabase(application);
        breedDao = db.breedDao();
        allBreeds = breedDao.getAllBreeds();
    }

    LiveData<List<Breed>> getAllBreeds() {
        return allBreeds;
    }

    public void insert (Breed breed) {
        new insertAsyncTask(breedDao).execute(breed);
    }

    private static class insertAsyncTask extends AsyncTask<Breed, Void, Void> {

        private BreedDao asyncTaskDao;

        insertAsyncTask(BreedDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Breed... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
