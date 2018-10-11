package com.schulz.erica.dogbreeds;

//DogBreedManager will replace the ApiTasks and the apiTasks will be removed from all activities &&
//DogBreedManager will eventually be injected using Dagger 2


import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DogBreedManager {

    Application dogBreedManager;

    public DogBreedManager(Application application) {
        dogBreedManager = application;
    }
    @Provides
    @Singleton
    Application providesApplication(){
        return dogBreedManager;
    }



    public void getBreedList(BreedListCallBack breedListCallBack) {


        if (this.hasLocalBreedList()) {

            //callback local database if true


        } else {

            BreedApiTask breedApiTask = new BreedApiTask(breedListCallBack);
            breedApiTask.execute();
        }


    }


    public void getSubBreedList(String breedName, BreedListCallBack breedListCallBack) {

        if (this.hasLocalBreedList()) {

            //callback local database if true


        } else {

            BreedApiTask subBreedApiTask = new BreedApiTask(breedName, breedListCallBack);
            subBreedApiTask.execute();

        }

    } private boolean hasLocalBreedList () {

        return false;
    }


    }

