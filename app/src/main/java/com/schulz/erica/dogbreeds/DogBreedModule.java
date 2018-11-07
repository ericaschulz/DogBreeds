package com.schulz.erica.dogbreeds;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module


public class DogBreedModule {


    @Provides
    @Singleton
    DogBreedModule provideDogBreedModule() {

        DogBreedModule dogBreedModule = new DogBreedModule();

        return dogBreedModule;
    }


}
