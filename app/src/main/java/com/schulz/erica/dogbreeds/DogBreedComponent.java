package com.schulz.erica.dogbreeds;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DogBreedModule.class})

public interface DogBreedComponent {

     void inject(BreedListActivity activity);
}






