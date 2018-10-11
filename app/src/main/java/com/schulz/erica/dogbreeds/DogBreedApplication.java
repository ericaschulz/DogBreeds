package com.schulz.erica.dogbreeds;

import android.app.Application;

public class DogBreedApplication extends Application {

    private DogBreedManagerComponent dogBreedManagerComponent;

    @Override
    public void onCreate(){
        super.onCreate();


        dogBreedManagerComponent = DaggerDogBreedManagerComponent.builder()
                .build();



    }
}
