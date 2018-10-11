package com.schulz.erica.dogbreeds;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DogBreedManager.class})

    public interface DogBreedManagerComponent {

    void inject(BreedListActivity activity);


    }




