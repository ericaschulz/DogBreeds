package com.schulz.erica.dogbreeds;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BreedViewModel extends AndroidViewModel {

    private BreedRepository breedRepository;
    private LiveData<List<Breed>> allBreeds;

    public BreedViewModel (Application application) {
        super(application);
        breedRepository = new BreedRepository(application);
        allBreeds = breedRepository.getAllBreeds();
    }
    LiveData<List<Breed>> getAllBreeds() { return allBreeds; }

    public void insert(Breed breed) { breedRepository.insert(breed); }

}





