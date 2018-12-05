package com.schulz.erica.dogbreeds.DI;

import com.schulz.erica.dogbreeds.BreedListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DogBreedModule.class})

public interface DogBreedComponent {

     void inject(BreedListActivity activity);


}






