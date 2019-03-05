package com.schulz.erica.dogbreeds.di;


import com.schulz.erica.dogbreeds.BreedApiTask;
import com.schulz.erica.dogbreeds.BreedListCallBack;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogBreedManager {

    private Retrofit retrofit;
    private static final String BASE_URL = "https://dog.ceo/api/";



    public DogBreedManager(){

        if (retrofit ==null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


    }

    public DogBreedInterface getDogBreedInterface() {

        return retrofit.create(DogBreedInterface.class);
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








