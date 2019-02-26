package com.schulz.erica.dogbreeds.di;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogBreedManager {

    //Singleton

    private static DogBreedManager dogBreedManager;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://dog.ceo/api/";

    public DogBreedManager() {

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

    }

    public static DogBreedManager getInstance() {

        if (dogBreedManager == null) {
            dogBreedManager = new DogBreedManager();
        }
        return dogBreedManager;

    }

    public DogBreedInterface getDogBreedInterface() {

        return retrofit.create(DogBreedInterface.class);

    }


}



        //request dogbreeds from internet...

        //translate JSON response into POJO

        //call the breedList callback


















