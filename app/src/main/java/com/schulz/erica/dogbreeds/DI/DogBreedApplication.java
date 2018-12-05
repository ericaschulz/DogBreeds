package com.schulz.erica.dogbreeds.DI;

import android.app.Application;

public class DogBreedApplication extends Application {

    private DogBreedComponent dogBreedComponent;

    @Override
    public void onCreate(){
        super.onCreate();

        dogBreedComponent = DaggerDogBreedComponent.builder()
                .dogBreedModule(new DogBreedModule())
                .build();


        }

    public DogBreedComponent getDogBreedComponent() {
        return dogBreedComponent;
    }
}






