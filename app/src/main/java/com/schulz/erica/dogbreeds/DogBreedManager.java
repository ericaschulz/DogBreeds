package com.schulz.erica.dogbreeds;

//DogBreedManager will replace the ApiTasks and the apiTasks will be removed from all activities &&
//DogBreedManager will eventually be injected using Dagger 2


import dagger.Module;


@Module
public class DogBreedManager {

//    private DogBreedManager dogBreedManager;
//
//
//    public DogBreedManager(DogBreedManager dogBreedManager) {
//        this.dogBreedManager = dogBreedManager;
//    }


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

