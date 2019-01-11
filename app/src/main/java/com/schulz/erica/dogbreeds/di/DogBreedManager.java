package com.schulz.erica.dogbreeds.di;


import com.schulz.erica.dogbreeds.BreedApiTask;
import com.schulz.erica.dogbreeds.BreedListCallBack;

public class DogBreedManager {


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







