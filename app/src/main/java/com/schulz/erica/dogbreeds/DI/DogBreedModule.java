package com.schulz.erica.dogbreeds.DI;

import com.schulz.erica.dogbreeds.BreedImageApiTaskCallBack;
import com.schulz.erica.dogbreeds.BreedListCallBack;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module


public class DogBreedModule {

    private BreedListCallBack breedListCallBack;
    private BreedImageApiTaskCallBack breedImageApiTaskCallBack;


    @Provides
    @Singleton
    DogBreedManager provideDogBreedManager() {

        DogBreedManager dogBreedManager = new DogBreedManager();

        return dogBreedManager;
    }


//    @Provides
//    @Singleton
//    private BreedListCallBack breedListAvailable(List<Breed> breedList){
//
//
//
//    }


}


//Might need to refactor this module as well as DogBreedManager//
