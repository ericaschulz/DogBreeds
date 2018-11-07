package com.schulz.erica.dogbreeds;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module


public class DogBreedModule {


    @Provides
    @Singleton
    DogBreedManager provideDogBreedManager() {

        DogBreedManager dogBreedManager = new DogBreedManager();

        return dogBreedManager;
    }


}
